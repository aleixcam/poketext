package pokemon.infrastructure.injector;

import pokemon.application.GetPokemons.GetPokemonsUseCase;

public class PokemonApplicationInjector {

    public static GetPokemonsUseCase injectGetPokemonsUseCase() {
        return new GetPokemonsUseCase(
                PokemonInfrastructureInjector.injectPokemonRepository(),
                PokemonInfrastructureInjector.injectPokemonTransformer()
        );
    }
}
