package teambuilder.team.infrastructure.injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import teambuilder.team.infrastructure.persistence.FileSystem.TeamRepositoryImpl;

public class TeamInfrastructureInjector {

    public static TeamRepositoryImpl injectFileSystemTeamRepository() {
        return new TeamRepositoryImpl(
            SharedInfrastructureInjector.injectCSVService()
        );
    }
}
