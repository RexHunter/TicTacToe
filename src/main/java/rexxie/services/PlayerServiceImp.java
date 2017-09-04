package rexxie.services;

import rexxie.entities.CellContent;
import rexxie.entities.Player;
import rexxie.input.GameInput;

public class PlayerServiceImp implements PlayerService {
    public static final Integer MAX_NUMBER_OF_TRIES = 5;

    private GameInput<String> stringGameInput;
    private GameInput<Integer> integerGameInput;

    public PlayerServiceImp(GameInput<String> stringGameInput, GameInput<Integer> integerGameInput) {
        this.stringGameInput = stringGameInput;
        this.integerGameInput = integerGameInput;
    }

    public Player getPlayer() throws InvalidValueEnteredTooManyTimesException {
        System.out.print("Enter player name: ");
        String playerName = stringGameInput.getInput();

        System.out.println("Marks: ");
        CellContent[] values = {CellContent.CROSS, CellContent.NOUGHT};
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + " - " + values[i]);
        }
        int tries = 0;
        while (tries <= MAX_NUMBER_OF_TRIES) {
            try {
                System.out.print("Select your mark: ");
                Integer cellContent = integerGameInput.getInput();
                return Player.createBuilder()
                        .setCellContent(values[cellContent - 1])
                        .setName(playerName)
                        .build();
            } catch (NumberFormatException e) {
                System.out.println("You entered incorrect value! Try more.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You entered value that out of range! Try more.");
            }
            tries++;
        }
        throw new InvalidValueEnteredTooManyTimesException();
    }

    public Player getPlayerWithOppositeCellContent(CellContent selectedContent) {
        System.out.print("Enter player name: ");
        String playerName = stringGameInput.getInput();

        return Player.createBuilder()
                .setCellContent((selectedContent == CellContent.CROSS) ? CellContent.NOUGHT : CellContent.CROSS)
                .setName(playerName).build();
    }
}
