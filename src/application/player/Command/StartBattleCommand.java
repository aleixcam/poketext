package application.player.Command;

import application.command.Command;
import infrastructure.presentation.controller.AppController;

final public class StartBattleCommand implements Command {

    private final AppController receiver;

    private StartBattleCommand(AppController receiver) {
        this.receiver = receiver;
    }

    public static StartBattleCommand of(AppController receiver) {
        return new StartBattleCommand(receiver);
    }

    public void execute(String... args) {
        receiver.play();
    }
}
