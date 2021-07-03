package teambuilder.team.infrastructure.Injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import teambuilder.pokemon.infrastructure.Injector.PokemonInfrastructureInjector;
import teambuilder.team.infrastructure.Persistence.FileSystem.CSVTeamRepository;
import teambuilder.team.infrastructure.Persistence.FileSystem.ShowdownTeamRepository;
import teambuilder.team.infrastructure.Transformer.ShowdownTeamTransformer;

public class TeamInfrastructureInjector {

    public static CSVTeamRepository csvTeamRepository() {
        return new CSVTeamRepository(
            SharedInfrastructureInjector.csvFileSystemManager()
        );
    }

    public static ShowdownTeamRepository showdownTeamRepository() {
        return new ShowdownTeamRepository(
            SharedInfrastructureInjector.showdownFileSystemManager(),
            showdownTeamTransformer()
        );
    }

    public static ShowdownTeamTransformer showdownTeamTransformer() {
        return new ShowdownTeamTransformer(
            PokemonInfrastructureInjector.showdownPokemonTransformer()
        );
    }
}
