package teambuilder.team.domain;

import indexer.pokemon.domain.PokemonCollection;
import shared.core.infrastructure.Service.ReaderService;
import teambuilder.team.infrastructure.Injector.TeamInfrastructureInjector;
import teambuilder.team.infrastructure.Persistence.FileSystem.CSVTeamRepository;

final public class Team {

    private final PokemonCollection pokemons;

    public Team(PokemonCollection pokemons) {
        this.pokemons = pokemons;
    }

    public PokemonCollection pokemons() {
        return pokemons;
    }

    public static String[][][] retrieve() {
        String[] pokemons = partyRepository().list();
        System.out.println("Saved teams:");
        for (String pokemon : pokemons) {
            System.out.println(pokemon);
        }

        return partyRepository().get(ReaderService.read());
    }

    private static CSVTeamRepository partyRepository() {
        return TeamInfrastructureInjector.csvTeamRepository();
    }
}
