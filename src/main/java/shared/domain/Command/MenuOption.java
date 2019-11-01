package shared.domain.Command;

class MenuOption {

    private final Command action;
    private final String text;

    MenuOption(Command action, String text) {
        this.action = action;
        this.text = text;
    }

    Command action() {
        return action;
    }

    String text() {
        return text;
    }
}
