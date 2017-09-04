package rexxie.input.console;

import rexxie.input.GameInput;
import rexxie.input.GameInputFactory;
import rexxie.input.console.IntegerConsoleGameInput;
import rexxie.input.console.StringConsoleGameInput;

import java.util.Scanner;

public class ConsoleGameInputFactory implements GameInputFactory {
    public static final int CONSOLE_STRING_GAME_INPUT = 0;
    public static final int CONSOLE_INT_GAME_INPUT = 1;

    @Override
    public GameInput getGameInput(int inputCodes) {
        Scanner scanner = new Scanner(System.in);

        switch (inputCodes) {
            case CONSOLE_STRING_GAME_INPUT:
                return new StringConsoleGameInput(scanner);
            case CONSOLE_INT_GAME_INPUT:
                return new IntegerConsoleGameInput(scanner);
        }

        return null;
    }
}
