package rexxie.services;

public class InvalidValueEnteredTooManyTimesException extends Exception {
    public InvalidValueEnteredTooManyTimesException() {
        super("Invalid value entered to may times!");
    }
}
