package rexxie;

import rexxie.condition.GameConditionFactory;
import rexxie.condition.GameConditions;
import rexxie.entities.Player;
import rexxie.game.ConsoleGame;
import rexxie.game.Game;
import rexxie.grid.GridFactory;
import rexxie.grid.Grids;
import rexxie.condition.GameCondition;
import rexxie.grid.Grid;
import rexxie.input.GameInput;
import rexxie.input.GameInputFactory;
import rexxie.input.console.ConsoleGameInputFactory;
import rexxie.renders.Renderable;
import rexxie.renders.RenderableFactory;
import rexxie.renders.Renderers;
import rexxie.services.InvalidValueEnteredTooManyTimesException;
import rexxie.services.PlayerService;
import rexxie.services.PlayerServiceImp;
import rexxie.sessions.PlayersSession;

public class Main {

    public static void main(String[] args) {
        //Init factory
        RenderableFactory renderableFactory = new RenderableFactory();
        GridFactory gridFactory = new GridFactory();
        GameConditionFactory gameConditionFactory = new GameConditionFactory();
        GameInputFactory gameInputFactory = new ConsoleGameInputFactory();

        //Load objects from factories
        Grid grid = gridFactory.getGrid(Grids.NORMAL);
        Renderable renderer = renderableFactory.getRender(Renderers.CONSOLE);
        GameCondition winCondition = gameConditionFactory.getGameCondition(GameConditions.NORMAL);
        GameInput<String> stringGameInput = gameInputFactory.getGameInput(ConsoleGameInputFactory.CONSOLE_STRING_GAME_INPUT);
        GameInput<Integer> integerGameInput = gameInputFactory.getGameInput(ConsoleGameInputFactory.CONSOLE_INT_GAME_INPUT);

        PlayerService playerService = new PlayerServiceImp(stringGameInput, integerGameInput);
        PlayersSession session = new PlayersSession();
        //Get users for game
        Player player1 = null;
        try {
            player1 = playerService.getPlayer();
        } catch (InvalidValueEnteredTooManyTimesException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        session.addPlayer(player1);

        Player player2 = playerService.getPlayerWithOppositeCellContent(player1.getCellContent());
        session.addPlayer(player2);

        Game game = new ConsoleGame(grid, session, renderer, winCondition, integerGameInput);
        game.run();
    }

}
