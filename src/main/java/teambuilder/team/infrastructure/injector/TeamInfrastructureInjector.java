package teambuilder.team.infrastructure.injector;

import shared.infrastructure.Injector.SharedInfrastructureInjector;
import teambuilder.team.infrastructure.persistence.FileSystem.TeamRepositoryImpl;

public class TeamInfrastructureInjector {

    public static TeamRepositoryImpl injectFileSystemTeamRepository() {
        return new TeamRepositoryImpl(
            SharedInfrastructureInjector.injectCSVService()
        );
    }
}
