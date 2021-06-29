package indexer.pokemon.infrastructure.persistence.SQLite;

import shared.core.infrastructure.Persistence.SQLite.SQLiteManager;
import shared.core.infrastructure.Service.LanguageService;
import indexer.pokemon.domain.*;
import indexer.pokemon.domain.ValueObject.BaseStats;
import shared.pokemon.domain.Pokemon;

import java.util.List;
import java.util.Map;
import java.util.Objects;

final public class SQLitePokemonRepository implements PokemonRepository {

    private final SQLiteManager repository;

    public SQLitePokemonRepository(SQLiteManager repository) {
        this.repository = repository;
    }

    public PokemonCollection findByCriteria(PokemonCriteria criteria) {
        List<Map<String, Object>> list = repository.executeQuery("select " + criteria.getIdField() + " 'id', p.identifier 'name',\n"
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

    private PokemonCollection buildPokemons(List<Map<String, Object>> list) {
        PokemonCollection pokemons = new PokemonCollection();
        for (Map<String, Object> row : list) {
            row.put("base_stats", findStatsByPokemonId((int) row.get("id")));
            pokemons.add(Pokemon.instance(row));
        }

        return pokemons;
    }

    public BaseStats findStatsByPokemonId(int pokemonId) {
        List<Map<String, Object>> list = repository.executeQuery("select"
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
            + "where p.id = " + pokemonId);

        return buildStats(list);
    }

    private BaseStats buildStats(List<Map<String, Object>> list) {
        return new BaseStats(
            (int) list.get(0).get("hp"),
            (int) list.get(0).get("atk"),
            (int) list.get(0).get("def"),
            (int) list.get(0).get("spatk"),
            (int) list.get(0).get("spdef"),
            (int) list.get(0).get("spe")
        );
    }
}
