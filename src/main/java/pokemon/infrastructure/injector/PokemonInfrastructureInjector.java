package pokemon.infrastructure.injector;

import shared.infrastructure.CommonInfrastructureInjector;
import pokemon.infrastructure.persistence.FileSystem.PokemonRepositoryImpl;
import pokemon.infrastructure.transformer.Matrix.PokemonTransformerImpl;

public class PokemonInfrastructureInjector {

    public static pokemon.infrastructure.persistence.SQLite.PokemonRepositoryImpl injectPokemonRepository() {
        return new pokemon.infrastructure.persistence.SQLite.PokemonRepositoryImpl(
            CommonInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static PokemonRepositoryImpl injectFileSystemPokemonRepository() {
        return new PokemonRepositoryImpl(
            CommonInfrastructureInjector.injectCSVService()
        );
    }

    public static PokemonTransformerImpl injectPokemonTransformer() {
        return new PokemonTransformerImpl(
            CommonInfrastructureInjector.injectMatrixService()
        );
    }
}
