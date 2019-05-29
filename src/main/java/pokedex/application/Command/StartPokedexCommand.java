package pokedex.application.Command;

import common.application.Command.Command;
import common.infrastructure.controller.AppController;

final public class StartPokedexCommand implements Command {

    private final AppController receiver;

    private StartPokedexCommand(AppController receiver) {
        this.receiver = receiver;
    }

    public static StartPokedexCommand of(AppController receiver) {
        return new StartPokedexCommand(receiver);
    }

    public void execute(String... args) {
        receiver.pokedex();
    }
}
