package indexer.pokedex.infrastructure.injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import indexer.pokedex.infrastructure.persistence.SQLite.SQLitePokedexRepository;
import indexer.pokedex.infrastructure.transformer.Matrix.MatrixPokedexTransformer;

public class PokedexInfrastructureInjector {

    public static SQLitePokedexRepository SQLitePokedexRepository() {
        return new SQLitePokedexRepository(
            SharedInfrastructureInjector.SQLiteManager()
        );
    }

    public static MatrixPokedexTransformer matrixPokedexTransformer() {
        return new MatrixPokedexTransformer(
            SharedInfrastructureInjector.matrixService()
        );
    }
}
