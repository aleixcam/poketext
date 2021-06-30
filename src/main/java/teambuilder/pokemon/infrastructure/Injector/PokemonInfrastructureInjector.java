package teambuilder.pokemon.infrastructure.Injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import teambuilder.pokemon.infrastructure.Persistence.FileSystem.CSVPokemonRepository;

public class PokemonInfrastructureInjector {

    public static CSVPokemonRepository csvPokemonRepository() {
        return new CSVPokemonRepository(
            SharedInfrastructureInjector.csvFileSystemManager()
        );
    }
}
