package teambuilder.team.infrastructure.controller;

import indexer.pokemon.domain.PokemonCollection;
import indexer.pokemon.infrastructure.injector.PokemonInfrastructureInjector;
import indexer.pokemon.infrastructure.persistence.FileSystem.PokemonRepositoryImpl;
import shared.infrastructure.Service.ReaderService;
import teambuilder.team.domain.Team;
import teambuilder.team.infrastructure.injector.TeamInfrastructureInjector;
import teambuilder.team.infrastructure.persistence.FileSystem.TeamRepositoryImpl;

public class TeamController {

    public void createTeamAction() {
        new Team(new PokemonCollection());
    }

    public void editTeamAction() {
        Team.retrieve();
    }

    public void removeTeamAction() {
        teamFileSystemRepository().erase(ReaderService.read());
    }

    public void removePokemonAction() {
        pokemonFileSystemRepository().erase(ReaderService.read());
    }

    private PokemonRepositoryImpl pokemonFileSystemRepository() {
        return PokemonInfrastructureInjector.injectFileSystemPokemonRepository();
    }

    private TeamRepositoryImpl teamFileSystemRepository() {
        return TeamInfrastructureInjector.injectFileSystemTeamRepository();
    }
}
