package rexxie.input.console;

import rexxie.input.GameInput;

import java.util.Scanner;

public abstract class ConsoleGameInput<T> implements GameInput<T> {
    private Scanner scanner;

    public ConsoleGameInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public T getInput() {
        String response = getScanner().nextLine();
        return map(response);
    }

    protected abstract T map(String response);

    private Scanner getScanner() {
        return scanner;
    }

}
