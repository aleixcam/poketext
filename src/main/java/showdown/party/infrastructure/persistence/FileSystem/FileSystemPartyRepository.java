package showdown.party.infrastructure.persistence.FileSystem;

import shared.core.infrastructure.Persistence.FileSystem.ShowdownFileSystemManager;
import showdown.party.domain.Party;
import showdown.party.domain.service.PartyRepository;


public class FileSystemPartyRepository implements PartyRepository {

    private final ShowdownFileSystemManager<Party> fileSystemManager;

    public FileSystemPartyRepository(ShowdownFileSystemManager<Party> fileSystemManager) {
        this.fileSystemManager = fileSystemManager;
    }

    public String[] list() {
        return this.fileSystemManager.list();
    }

    public Party get(String ref) {
        return this.fileSystemManager.read(ref);
    }
}
