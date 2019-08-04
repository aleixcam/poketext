package pokemon.infrastructure.injector;

import shared.infrastructure.injector.SharedInfrastructureInjector;
import pokemon.infrastructure.persistence.FileSystem.PokemonRepositoryImpl;
import pokemon.infrastructure.transformer.Matrix.PokemonTransformerImpl;

public class PokemonInfrastructureInjector {

    public static pokemon.infrastructure.persistence.SQLite.PokemonRepositoryImpl injectPokemonRepository() {
        return new pokemon.infrastructure.persistence.SQLite.PokemonRepositoryImpl(
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
