package teambuilder.team.infrastructure.Injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import teambuilder.team.infrastructure.Persistence.FileSystem.CSVTeamRepository;
import teambuilder.team.infrastructure.Persistence.FileSystem.ShowdownTeamRepository;

public class TeamInfrastructureInjector {

    public static CSVTeamRepository csvTeamRepository() {
        return new CSVTeamRepository(
            SharedInfrastructureInjector.csv3FileSystemManager()
        );
    }

    public static ShowdownTeamRepository showdownTeamRepository() {
        return new ShowdownTeamRepository(
                SharedInfrastructureInjector.showdownFileSystemManager()
        );
    }
}
