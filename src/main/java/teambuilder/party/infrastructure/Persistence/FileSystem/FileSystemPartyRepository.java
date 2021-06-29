package teambuilder.party.infrastructure.Persistence.FileSystem;

import shared.core.infrastructure.Persistence.FileSystem.CSV3FileSystemManager;
import teambuilder.party.domain.Service.PartyRepository;

final public class FileSystemPartyRepository implements PartyRepository {

    private final CSV3FileSystemManager fileSystemManager;

    public FileSystemPartyRepository(CSV3FileSystemManager fileSystemManager) {
        this.fileSystemManager = fileSystemManager;
        this.fileSystemManager.setDirectory("data/memory/team");
    }

    public String[] list() {
        return this.fileSystemManager.list();
    }

    public String[][][] get(String ref) {
        return this.fileSystemManager.read(ref);
    }

    @Override
    public void remove(String ref) {
        this.fileSystemManager.erase(ref);
    }
}
