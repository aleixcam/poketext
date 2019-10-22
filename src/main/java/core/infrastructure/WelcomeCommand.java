package core.infrastructure;

import shared.domain.Command.Command;
import core.infrastructure.controller.AppController;

final public class WelcomeCommand implements Command {

    private final AppController receiver;

    private WelcomeCommand(AppController receiver) {
        this.receiver = receiver;
    }

    public static WelcomeCommand of(AppController receiver) {
        return new WelcomeCommand(receiver);
    }

    public void execute(String... args) {
        receiver.welcome();
    }
}
