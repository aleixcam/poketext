package application.pokemon.Command;

import application.command.Command;
import application.pokemon.Service.SearchPokemonsService;

final public class SetTypeFilterCommand implements Command {

    private final SearchPokemonsService receiver;

    private SetTypeFilterCommand(SearchPokemonsService receiver) {
        this.receiver = receiver;
    }

    public static SetTypeFilterCommand of(SearchPokemonsService receiver) {
        return new SetTypeFilterCommand(receiver);
    }

    public void execute(String... args) {
        receiver.setTypeFilter(args[0]);
    }
}
