package team.infrastructure.injector;

import team.infrastructure.persistence.FileSystem.TeamRepositoryFileSystem;

public class TeamInfrastructureInjector {

    public static TeamRepositoryFileSystem injectFileSystemTeamRepository() {
        return new TeamRepositoryFileSystem();
    }
}
