package application.command;

public class InvalidSelectionException extends Exception {

    public String getMessage() {
        return "Invalid selection";
    }
}
