package teambuilder.team.infrastructure.controller;

import indexer.pokemon.infrastructure.injector.PokemonInfrastructureInjector;
import indexer.pokemon.infrastructure.persistence.FileSystem.PokemonRepositoryImpl;
import shared.infrastructure.service.ReaderService;
import teambuilder.team.infrastructure.injector.TeamInfrastructureInjector;
import teambuilder.team.infrastructure.persistence.FileSystem.TeamRepositoryImpl;
import teambuilder.team.legacy.Equips;

public class TeamController {

    public static void createTeamAction() {
        Equips.crearEquip(new String[6][][]);
    }

    public static void importTeamAction() {
        String[] pokemons = teamFileSystemRepository().list();
        System.out.println("Saved teams:");
        for (String pokemon : pokemons) {
            System.out.println(pokemon);
        }

        Equips.crearEquip(teamFileSystemRepository().read(ReaderService.read()));
    }

    public static void removeTeamAction() {
        teamFileSystemRepository().erase(ReaderService.read());
    }

    public static void removePokemonAction() {
        pokemonFileSystemRepository().erase(ReaderService.read());
    }

    private static PokemonRepositoryImpl pokemonFileSystemRepository() {
        return PokemonInfrastructureInjector.injectFileSystemPokemonRepository();
    }

    private static TeamRepositoryImpl teamFileSystemRepository() {
        return TeamInfrastructureInjector.injectFileSystemTeamRepository();
    }
}
