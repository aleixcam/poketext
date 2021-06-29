package showdown.party.infrastructure.injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import showdown.party.infrastructure.persistence.FileSystem.FileSystemPartyRepository;
import teambuilder.pokemon.infrastructure.persistence.FileSystem.FileSystemPokemonRepository;

public class PartyInfrastructureInjector {

    public static FileSystemPartyRepository fileSystemPartyRepository() {
        return new FileSystemPartyRepository(
            SharedInfrastructureInjector.showdownFileSystemManager()
        );
    }
}
