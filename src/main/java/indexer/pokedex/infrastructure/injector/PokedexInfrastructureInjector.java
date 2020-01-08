package indexer.pokedex.infrastructure.injector;

import shared.infrastructure.Injector.SharedInfrastructureInjector;
import indexer.pokedex.infrastructure.persistence.SQLite.PokedexRepositoryImpl;
import indexer.pokedex.infrastructure.transformer.Matrix.PokedexTransformerImpl;

public class PokedexInfrastructureInjector {

    public static PokedexRepositoryImpl injectPokedexRepository() {
        return new PokedexRepositoryImpl(
            SharedInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static PokedexTransformerImpl injectPokedexTransformer() {
        return new PokedexTransformerImpl(
            SharedInfrastructureInjector.injectMatrixService()
        );
    }
}
