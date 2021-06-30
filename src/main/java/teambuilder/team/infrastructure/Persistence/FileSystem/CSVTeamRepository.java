package teambuilder.team.infrastructure.Persistence.FileSystem;

import shared.core.infrastructure.Persistence.FileSystem.CSV3FileSystemManager;
import teambuilder.team.domain.Service.TeamRepository;
import teambuilder.team.domain.Team;

final public class CSVTeamRepository implements TeamRepository {

    private final CSV3FileSystemManager fileSystemManager;

    public CSVTeamRepository(CSV3FileSystemManager fileSystemManager) {
        this.fileSystemManager = fileSystemManager;
        this.fileSystemManager.setDirectory("data/memory/team");
    }

    public String[] list() {
        return this.fileSystemManager.list();
    }

    public String[][][] get(String ref) {
        return this.fileSystemManager.read(ref);
    }

    public void remove(String ref) {
        this.fileSystemManager.erase(ref);
    }
}
