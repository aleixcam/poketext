package teambuilder.team.infrastructure.Persistence.FileSystem;

import shared.core.infrastructure.Persistence.FileSystem.ShowdownTeamFileSystemManager;
import teambuilder.team.domain.Service.TeamRepository;
import teambuilder.team.domain.Team;

public class ShowdownTeamRepository implements TeamRepository {

    private final ShowdownTeamFileSystemManager<Team> fileSystemManager;

    public ShowdownTeamRepository(ShowdownTeamFileSystemManager<Team> fileSystemManager) {
        this.fileSystemManager = fileSystemManager;
    }

    public String[] list() {
        return this.fileSystemManager.list();
    }

    public Team get(String ref) {
        return this.fileSystemManager.read(ref);
    }

    public void remove(String ref) {
        this.fileSystemManager.erase(ref);
    }
}
