package application.item.Command;

import application.command.Command;
import infrastructure.presentation.controller.PokedexController;

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