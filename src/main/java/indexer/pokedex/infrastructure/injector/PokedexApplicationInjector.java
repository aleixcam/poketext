package indexer.pokedex.infrastructure.injector;

import indexer.pokedex.application.GetPokedexes.GetPokedexesUseCase;

public class PokedexApplicationInjector {

    public static GetPokedexesUseCase<String[][]> injectGetPokedexesUseCase() {
        return new GetPokedexesUseCase<>(
                PokedexInfrastructureInjector.SQLitePokedexRepository(),
                PokedexInfrastructureInjector.matrixPokedexTransformer()
        );
    }
}
