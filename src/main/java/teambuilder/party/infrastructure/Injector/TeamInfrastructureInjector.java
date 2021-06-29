package teambuilder.party.infrastructure.Injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import teambuilder.party.infrastructure.Persistence.FileSystem.FileSystemPartyRepository;

public class TeamInfrastructureInjector {

    public static FileSystemPartyRepository fileSystemPartyRepository() {
        return new FileSystemPartyRepository(
            SharedInfrastructureInjector.csv3FileSystemManager()
        );
    }
}
