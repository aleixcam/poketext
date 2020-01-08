package indexer.pokedex.application.Command;

import shared.core.domain.Command.Command;
import shared.core.infrastructure.Controller.AppController;

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
