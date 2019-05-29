package common.application.Command;

public class InvalidSelectionException extends Exception {

    public String getMessage() {
        return "Invalid selection";
    }
}
