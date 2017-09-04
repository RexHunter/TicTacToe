package rexxie.input.console;

import java.util.Scanner;

public class IntegerConsoleGameInput extends ConsoleGameInput<Integer> {
    public IntegerConsoleGameInput(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected Integer map(String response) {
        return Integer.parseInt(response);
    }
}
