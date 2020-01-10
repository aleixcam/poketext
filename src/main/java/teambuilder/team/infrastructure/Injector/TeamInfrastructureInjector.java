package teambuilder.team.infrastructure.Injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import teambuilder.team.infrastructure.Persistence.FileSystem.TeamRepositoryImpl;

public class TeamInfrastructureInjector {

    public static TeamRepositoryImpl injectFileSystemTeamRepository() {
        return new TeamRepositoryImpl(
            SharedInfrastructureInjector.injectCSVService()
        );
    }
}
