package indexer.pokemon.application.Command;

import shared.core.domain.Command.Command;
import indexer.pokedex.infrastructure.controller.PokedexController;

final public class SearchPokemonsCommand implements Command {

    private final PokedexController receiver;

    private SearchPokemonsCommand(PokedexController receiver) {
        this.receiver = receiver;
    }

    public static SearchPokemonsCommand of(PokedexController receiver) {
        return new SearchPokemonsCommand(receiver);
    }

    @Override
    public void execute(String... args) {
        receiver.pokemons();
    }
}
