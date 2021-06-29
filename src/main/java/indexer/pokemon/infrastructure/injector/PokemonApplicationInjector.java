package indexer.pokemon.infrastructure.injector;

import indexer.pokemon.application.GetPokemons.GetPokemonsUseCase;

public class PokemonApplicationInjector {

    public static GetPokemonsUseCase injectGetPokemonsUseCase() {
        return new GetPokemonsUseCase(
                PokemonInfrastructureInjector.SQLitePokemonRepository(),
                PokemonInfrastructureInjector.matrixPokemonTransformer()
        );
    }
}
