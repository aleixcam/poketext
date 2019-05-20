package application.pokemon.Command;

import application.command.Command;
import application.pokemon.Service.SearchPokemonsService;

public class SetTypeFilterCommand implements Command {

    private final SearchPokemonsService receiver;

    public SetTypeFilterCommand(SearchPokemonsService receiver) {
        this.receiver = receiver;
    }

    public void execute(String... args) {
        receiver.setTypeFilter(args[0]);
    }
}
