package teambuilder.team.infrastructure.Persistence.FileSystem;

import shared.core.domain.ShowdownPokemon;
import shared.core.infrastructure.Persistence.FileSystem.ShowdownFileSystemManager;
import teambuilder.team.domain.Service.TeamRepository;
import teambuilder.team.domain.Service.TeamTransformer;
import teambuilder.team.domain.Team;

final public class ShowdownTeamRepository implements TeamRepository<Team> {

    private final ShowdownFileSystemManager fileSystemManager;
    private final TeamTransformer<ShowdownPokemon> transformer;

    public ShowdownTeamRepository(
            ShowdownFileSystemManager fileSystemManager,
            TeamTransformer<ShowdownPokemon> transformer
    ) {
        this.fileSystemManager = fileSystemManager;
        this.transformer = transformer;
        this.fileSystemManager.setDirectory("data/memory/team");
    }

    public String[] list() {
        return this.fileSystemManager.list();
    }

    public Team get(String ref) {
        return this.transformer.reverseTransform(this.fileSystemManager.importMany(ref));
    }

    public void remove(String ref) {
        this.fileSystemManager.erase(ref);
    }
}
