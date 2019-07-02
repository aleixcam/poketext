package pokemon.infrastructure.injector;

import common.infrastructure.CommonInfrastructureInjector;
import pokemon.infrastructure.persistence.FileSystem.PokemonRepositoryFileSystem;
import pokemon.infrastructure.persistence.SQLite.PokemonRepositoryImpl;
import pokemon.infrastructure.transformer.Matrix.PokemonTransformerImpl;

public class PokemonInfrastructureInjector {

    public static PokemonRepositoryImpl injectPokemonRepository() {
        return new PokemonRepositoryImpl(
            CommonInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static PokemonRepositoryFileSystem injectFileSystemPokemonRepository() {
        return new PokemonRepositoryFileSystem();
    }

    public static PokemonTransformerImpl injectPokemonTransformer() {
        return new PokemonTransformerImpl();
    }
}
