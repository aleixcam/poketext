package teambuilder.party.infrastructure.Controller;

import indexer.pokemon.domain.PokemonCollection;
import shared.core.infrastructure.Service.ReaderService;
import teambuilder.pokemon.infrastructure.injector.PokemonInfrastructureInjector;
import teambuilder.party.domain.Team;
import teambuilder.party.infrastructure.Injector.TeamInfrastructureInjector;

public class TeamController {

    public void createTeamAction() {
        new Team(new PokemonCollection());
    }

    public void editTeamAction() {
        Team.retrieve();
    }

    public void removeTeamAction() {
        TeamInfrastructureInjector.fileSystemPartyRepository().remove(ReaderService.read());
    }

    public void removePokemonAction() {
        PokemonInfrastructureInjector.fileSystemPokemonRepository().remove(ReaderService.read());
    }
}
