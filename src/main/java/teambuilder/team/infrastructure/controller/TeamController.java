package teambuilder.team.infrastructure.controller;

import indexer.pokemon.infrastructure.injector.PokemonInfrastructureInjector;
import indexer.pokemon.infrastructure.persistence.FileSystem.PokemonRepositoryImpl;
import shared.infrastructure.service.ReaderService;
import teambuilder.team.infrastructure.injector.TeamInfrastructureInjector;
import teambuilder.team.infrastructure.persistence.FileSystem.TeamRepositoryImpl;
import teambuilder.team.legacy.Equips;

public class TeamController {

    public void createTeamAction() {
        Equips.crearEquip(new String[6][][]);
    }

    public void editTeamAction() {
        Equips.crearEquip(Equips.importarEquip());
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
