package indexer.pokedex.infrastructure.injector;

import indexer.pokedex.application.GetPokedexes.GetPokedexesUseCase;

public class PokedexApplicationInjector {

    public static GetPokedexesUseCase injectGetPokedexesUseCase() {
        return new GetPokedexesUseCase(
                PokedexInfrastructureInjector.injectPokedexRepository(),
                PokedexInfrastructureInjector.injectPokedexTransformer()
        );
    }
}
