package team.infrastructure.injector;

import shared.infrastructure.CommonInfrastructureInjector;
import team.infrastructure.persistence.FileSystem.TeamRepositoryImpl;

public class TeamInfrastructureInjector {

    public static TeamRepositoryImpl injectFileSystemTeamRepository() {
        return new TeamRepositoryImpl(
            CommonInfrastructureInjector.injectCSVService()
        );
    }
}
