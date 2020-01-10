package teambuilder.team.domain;

import indexer.pokemon.domain.PokemonCollection;
import shared.core.infrastructure.Service.ReaderService;
import teambuilder.team.infrastructure.Injector.TeamInfrastructureInjector;
import teambuilder.team.infrastructure.Persistence.FileSystem.TeamRepositoryImpl;

final public class Team {

    private PokemonCollection pokemons;

    public Team(PokemonCollection pokemons) {
        this.pokemons = pokemons;
    }

    public PokemonCollection pokemons() {
        return pokemons;
    }

    public static String[][][] retrieve() {
        String[] pokemons = teamFileSystemRepository().list();
        System.out.println("Saved teams:");
        for (String pokemon : pokemons) {
            System.out.println(pokemon);
        }

        return teamFileSystemRepository().read(ReaderService.read());
    }

    private static TeamRepositoryImpl teamFileSystemRepository() {
        return TeamInfrastructureInjector.injectFileSystemTeamRepository();
    }
}
