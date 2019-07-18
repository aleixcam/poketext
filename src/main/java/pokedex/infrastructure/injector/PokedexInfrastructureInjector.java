package pokedex.infrastructure.injector;

import common.infrastructure.CommonInfrastructureInjector;
import pokedex.infrastructure.persistence.SQLite.PokedexRepositoryImpl;
import pokedex.infrastructure.transformer.Matrix.PokedexTransformerImpl;

public class PokedexInfrastructureInjector {

    public static PokedexRepositoryImpl injectPokedexRepository() {
        return new PokedexRepositoryImpl(
            CommonInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static PokedexTransformerImpl injectPokedexTransformer() {
        return new PokedexTransformerImpl(
            CommonInfrastructureInjector.injectMatrixService()
        );
    }
}
