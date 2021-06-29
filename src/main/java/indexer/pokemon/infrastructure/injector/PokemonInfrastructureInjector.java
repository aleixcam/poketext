package indexer.pokemon.infrastructure.injector;

import indexer.pokemon.infrastructure.persistence.SQLite.SQLitePokemonRepository;
import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import indexer.pokemon.infrastructure.transformer.Matrix.MatrixPokemonTransformer;

public class PokemonInfrastructureInjector {

    public static SQLitePokemonRepository SQLitePokemonRepository() {
        return new SQLitePokemonRepository(
            SharedInfrastructureInjector.SQLiteManager()
        );
    }

    public static MatrixPokemonTransformer matrixPokemonTransformer() {
        return new MatrixPokemonTransformer(
            SharedInfrastructureInjector.matrixService()
        );
    }
}
