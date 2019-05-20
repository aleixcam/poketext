package application.pokedex.Command;

import application.command.Command;
import application.pokemon.Service.SearchPokemonsService;

public class SelectPokedexCommand implements Command {

    private final SearchPokemonsService receiver;

    public SelectPokedexCommand(SearchPokemonsService receiver) {
        this.receiver = receiver;
    }

    public void execute(String... args) {
        receiver.selectPokedex();
    }
}
