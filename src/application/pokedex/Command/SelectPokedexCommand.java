package application.pokedex.Command;

import application.command.Command;
import application.pokemon.Service.SearchPokemonsService;

final public class SelectPokedexCommand implements Command {

    private final SearchPokemonsService receiver;

    private SelectPokedexCommand(SearchPokemonsService receiver) {
        this.receiver = receiver;
    }

    public static SelectPokedexCommand of(SearchPokemonsService receiver) {
        return new SelectPokedexCommand(receiver);
    }

    public void execute(String... args) {
        receiver.selectPokedex();
    }
}
