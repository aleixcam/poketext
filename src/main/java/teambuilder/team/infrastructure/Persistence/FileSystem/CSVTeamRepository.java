package teambuilder.team.infrastructure.Persistence.FileSystem;

import shared.core.infrastructure.Persistence.FileSystem.CSVFileSystemManager;
import teambuilder.team.domain.Service.TeamRepository;

final public class CSVTeamRepository implements TeamRepository<String[][][]> {

    private final CSVFileSystemManager fileSystemManager;

    public CSVTeamRepository(CSVFileSystemManager fileSystemManager) {
        this.fileSystemManager = fileSystemManager;
        this.fileSystemManager.setDirectory("data/memory/team");
    }

    public String[] list() {
        return this.fileSystemManager.list();
    }

    public String[][][] get(String ref) {
        return this.fileSystemManager.importMany(ref);
    }

    public void remove(String ref) {
        this.fileSystemManager.erase(ref);
    }
}
