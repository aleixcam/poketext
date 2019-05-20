package application.pokemon.Command;

import application.command.Command;
import application.pokemon.Service.SearchPokemonsService;

final public class SetNameFilterCommand implements Command {

    private final SearchPokemonsService receiver;

    private SetNameFilterCommand(SearchPokemonsService receiver) {
        this.receiver = receiver;
    }

    public static SetNameFilterCommand of(SearchPokemonsService receiver) {
        return new SetNameFilterCommand(receiver);
    }

    public void execute(String... args) {
        receiver.setNameFilter(args[0]);
    }
}
