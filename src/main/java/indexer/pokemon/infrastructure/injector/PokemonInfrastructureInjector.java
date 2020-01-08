package indexer.pokemon.infrastructure.injector;

import shared.infrastructure.Injector.SharedInfrastructureInjector;
import indexer.pokemon.infrastructure.persistence.FileSystem.PokemonRepositoryImpl;
import indexer.pokemon.infrastructure.transformer.Matrix.PokemonTransformerImpl;

public class PokemonInfrastructureInjector {

    public static indexer.pokemon.infrastructure.persistence.SQLite.PokemonRepositoryImpl injectPokemonRepository() {
        return new indexer.pokemon.infrastructure.persistence.SQLite.PokemonRepositoryImpl(
            SharedInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static PokemonRepositoryImpl injectFileSystemPokemonRepository() {
        return new PokemonRepositoryImpl(
            SharedInfrastructureInjector.injectCSVService()
        );
    }

    public static PokemonTransformerImpl injectPokemonTransformer() {
        return new PokemonTransformerImpl(
            SharedInfrastructureInjector.injectMatrixService()
        );
    }
}
