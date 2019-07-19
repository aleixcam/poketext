package pokemon.infrastructure.persistence.SQLite;

import common.domain.service.SQLiteRepository;
import common.infrastructure.service.LanguageService;
import pokemon.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

final public class PokemonRepositoryImpl implements PokemonRepository {

    private final SQLiteRepository repository;

    public PokemonRepositoryImpl(SQLiteRepository repository) {
        this.repository = repository;
    }

    public PokemonsCollection findByCriteria(PokemonCriteria criteria) {
        List<String[]> list = repository.executeQuery("select " + criteria.getIdField() + " 'id', p.identifier 'name',\n"
            + "(select n.name\n"
            + "from type_names n, pokemon_types t\n"
            + "where n.type_id = t.type_id\n"
            + "and p.id = t.pokemon_id\n"
            + "and n.local_language_id = " + LanguageService.ENGLISH + "\n"
            + "and t.slot = 1) 'type_one',\n"
            + "(select n.name\n"
            + "from type_names n, pokemon_types t\n"
            + "where n.type_id = t.type_id\n"
            + "and p.id = t.pokemon_id\n"
            + "and n.local_language_id = " + LanguageService.ENGLISH + "\n"
            + "and t.slot = 2) 'type_two'\n"
            + "from pokemon p, pokemon_dex_numbers d\n"
            + "where p.species_id = d.species_id\n"
            + "and d.pokedex_id = " + criteria.getPokedexId() + "\n"
            + (!Objects.equals(criteria.getName(), "") ? "and p.identifier like '%" + criteria.getName() + "%'\n" : "")
            + (!Objects.equals(criteria.getType(), "") ? "and (type_one like '%" + criteria.getType() + "%'"
            + "or type_two like '%" + criteria.getType() + "%')\n" : "")
            + (criteria.getPokedexId() != 1 ? "and p.is_default = 1\n" : "")
            + "order by " + criteria.getIdField());

        return buildPokemons(list);
    }

    private PokemonsCollection buildPokemons(List<String[]> list) {
        PokemonsCollection pokemons = new PokemonsCollection();
        for (String[] row : list) {
            Pokemon pokemon = new Pokemon();
            pokemon.setId(row[0]);
            pokemon.setName(row[1]);
            pokemon.setTypeOne(row[2]);
            pokemon.setTypeTwo(row[3]);
            pokemon.setBaseStats(findStatsByPokemonId(pokemon.getId()));

            pokemons.add(pokemon);
        }

        return pokemons;
    }

    public BaseStats findStatsByPokemonId(int pokemon_id) {
        List<String[]> list = repository.executeQuery("select"
            + "(select s.base_stat\n"
            + "from pokemon_stats s\n"
            + "where p.id = s.pokemon_id\n"
            + "and s.stat_id = 1) 'hp',\n"
            + "(select s.base_stat\n"
            + "from pokemon_stats s\n"
            + "where p.id = s.pokemon_id\n"
            + "and s.stat_id = 2) 'atk',\n"
            + "(select s.base_stat\n"
            + "from pokemon_stats s\n"
            + "where p.id = s.pokemon_id\n"
            + "and s.stat_id = 3) 'def',\n"
            + "(select s.base_stat\n"
            + "from stat_names n, pokemon_stats s\n"
            + "where p.id = s.pokemon_id\n"
            + "and s.stat_id = 4) 'spatk',\n"
            + "(select s.base_stat\n"
            + "from pokemon_stats s\n"
            + "where p.id = s.pokemon_id\n"
            + "and s.stat_id = 5) 'spdef',\n"
            + "(select s.base_stat\n"
            + "from pokemon_stats s\n"
            + "where p.id = s.pokemon_id\n"
            + "and s.stat_id = 6) 'spe'\n"
            + "from pokemon p\n"
            + "where p.id = " + pokemon_id);

        return buildStats(list);
    }

    private BaseStats buildStats(List<String[]> list) {
        int[] stats = Arrays.stream(list.get(0)).mapToInt(Integer::parseInt).toArray();

        return new BaseStats(stats[0], stats[1], stats[2],stats[3], stats[4], stats[5]);
    }
}
