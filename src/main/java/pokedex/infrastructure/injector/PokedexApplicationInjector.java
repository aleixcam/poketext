package pokedex.infrastructure.injector;

import pokedex.application.GetPokedexes.GetPokedexesUseCase;

public class PokedexApplicationInjector {

    public static GetPokedexesUseCase injectGetPokedexesUseCase() {
        return new GetPokedexesUseCase(
                PokedexInfrastructureInjector.injectPokedexRepository(),
                PokedexInfrastructureInjector.injectPokedexTransformer()
        );
    }
}
