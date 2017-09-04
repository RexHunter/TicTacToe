package rexxie.input.console;

import java.util.Scanner;

public class StringConsoleGameInput extends ConsoleGameInput<String> {
    public StringConsoleGameInput(Scanner scanner) {
        super(scanner);
    }

    @Override
    protected String map(String response) {
        return response;
    }
}
