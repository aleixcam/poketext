package application.pokemon.Command;

import application.command.Command;
import application.pokemon.Service.SearchPokemonsService;

public class SetNameFilterCommand implements Command {

    private final SearchPokemonsService receiver;

    public SetNameFilterCommand(SearchPokemonsService receiver) {
        this.receiver = receiver;
    }

    public void execute(String... args) {
        receiver.setNameFilter(args[0]);
    }
}
