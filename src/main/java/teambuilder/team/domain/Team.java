package teambuilder.team.domain;

import shared.core.infrastructure.Service.ReaderService;
import teambuilder.pokemon.domain.Pokemon;
import teambuilder.team.infrastructure.Injector.TeamInfrastructureInjector;
import teambuilder.team.infrastructure.Persistence.FileSystem.CSVTeamRepository;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.List;

final public class Team {

    public static final int MAX_SIZE = 6;

    private final List<Pokemon> pokemons;

    public Team(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public static Team empty() {
        return new Team(new ArrayList<>());
    }

    public static Team fromPokemons(Pokemon[] pokemons) {
        Team team = Team.empty();

        for (Pokemon pokemon : pokemons) {
            try {
                team.add(pokemon);
            } catch (LimitExceededException e) {
                break;
            }
        }

        return team;
    }

    public void add(Pokemon pokemon) throws LimitExceededException {
        guardFromTooManyPokemons();
        pokemons.add(pokemon);
    }

    public List<Pokemon> pokemons() {
        return pokemons;
    }

    private void guardFromTooManyPokemons() throws LimitExceededException {
        if (pokemons.size() > MAX_SIZE) {
            throw new LimitExceededException();
        }
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
