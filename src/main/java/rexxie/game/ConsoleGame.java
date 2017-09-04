package rexxie.game;

import rexxie.condition.GameCondition;
import rexxie.entities.Player;
import rexxie.grid.Grid;
import rexxie.grid.exceptions.CellIsAlreadyFilled;
import rexxie.grid.exceptions.ValueIsOutOfRangeException;
import rexxie.input.GameInput;
import rexxie.renders.Renderable;
import rexxie.sessions.PlayersSession;

public class ConsoleGame implements Game {
    private boolean running;
    private Grid grid;
    private PlayersSession session;
    private Renderable renderer;
    private GameCondition condition;
    private GameInput<Integer> integerGameInput;

    public ConsoleGame(Grid grid,
                       PlayersSession session,
                       Renderable renderer,
                       GameCondition condition,
                       GameInput<Integer> integerGameInput) {
        this.grid = grid;
        this.session = session;
        this.renderer = renderer;
        this.condition = condition;
        this.integerGameInput = integerGameInput;
    }

    @Override
    public void run() {
        running = true;
        renderer.render(grid);
        int turn = 0;
        while (running) {
            Player player = session.nextPlayer();
            System.out.println(player.getName() + " turn:");
            boolean valueIsEntered = false;
            while (!valueIsEntered) {

                try {
                    System.out.print("Enter row number: ");
                    Integer row = integerGameInput.getInput();
                    System.out.print("Enter col number: ");
                    Integer col = integerGameInput.getInput();

                    grid.fillCell(row, col, player.getCellContent());

                    renderer.render(grid);

                    boolean playerWonTheGame = condition.validate(row, col, player.getCellContent(), grid);
                    boolean lastTurn = (turn == grid.getColCount() * grid.getRowCount() - 1);
                    if (playerWonTheGame) {
                        System.out.println(player.getName() + " won the game!");
                    } else if (lastTurn) {
                        System.out.println("Match ended in a draw!");
                    }

                    if (playerWonTheGame || lastTurn) {
                        System.out.print("Do you want to start new game? (0\\1):");
                        Integer response = integerGameInput.getInput();
                        if (response == 0) {
                            stop();
                        } else {
                            turn = 0;
                            session.restart();
                            grid.clear();
                            renderer.render(grid);
                        }
                    } else {
                        turn++;
                    }

                    valueIsEntered = true;
                } catch (ValueIsOutOfRangeException | CellIsAlreadyFilled e) {
                    System.out.println(e.getMessage() + ". Try more!");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid entered value. " + e.getMessage() + ". Try more!");
                }
            }
        }
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
