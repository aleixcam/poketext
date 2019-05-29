package item.application.Command;

import common.application.Command.Command;
import common.infrastructure.controller.PokedexController;

final public class SearchItemsCommand implements Command {

    private final PokedexController receiver;

    private SearchItemsCommand(PokedexController receiver) {
        this.receiver = receiver;
    }

    public static SearchItemsCommand of(PokedexController receiver) {
        return new SearchItemsCommand(receiver);
    }

    public void execute(String... args) {
        receiver.items();
    }
}