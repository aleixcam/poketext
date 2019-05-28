package application.move.Command;

import application.command.Command;
import infrastructure.presentation.controller.PokedexController;

final public class SearchMovesCommand implements Command {

    private final PokedexController receiver;

    private SearchMovesCommand(PokedexController receiver) {
        this.receiver = receiver;
    }

    public static SearchMovesCommand of(PokedexController receiver) {
        return new SearchMovesCommand(receiver);
    }

    public void execute(String... args) {
        receiver.moves();
    }
}
