package teambuilder.team.infrastructure.Injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import teambuilder.pokemon.infrastructure.Injector.PokemonInfrastructureInjector;
import teambuilder.team.infrastructure.Persistence.FileSystem.CSVTeamRepository;
import teambuilder.team.infrastructure.Persistence.FileSystem.ShowdownTeamRepository;
import teambuilder.team.infrastructure.Transformer.ShowdownTeamTransformerImpl;

public class TeamInfrastructureInjector {

    public static CSVTeamRepository csvTeamRepository() {
        return new CSVTeamRepository(
            SharedInfrastructureInjector.csv3FileSystemManager()
        );
    }

    public static ShowdownTeamRepository showdownTeamRepository() {
        return new ShowdownTeamRepository(
            SharedInfrastructureInjector.showdownTeamFileSystemManager(
                showdownTeamTransformer()
            )
        );
    }

    public static ShowdownTeamTransformerImpl showdownTeamTransformer() {
        return new ShowdownTeamTransformerImpl(
            PokemonInfrastructureInjector.showdownPokemonTransformer()
        );
    }
}
