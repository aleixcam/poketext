package indexer.pokedex.application.Command;

import shared.core.domain.Command.Command;
import shared.core.infrastructure.Controller.AppController;

final public class IndexerCommand implements Command {

    private final AppController receiver;

    private IndexerCommand(AppController receiver) {
        this.receiver = receiver;
    }

    public static IndexerCommand of(AppController receiver) {
        return new IndexerCommand(receiver);
    }

    public void execute(String... args) {
        receiver.indexer();
    }
}
