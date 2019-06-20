package pokedex.infrastructure.persistence.SQLite;

import common.infrastructure.persistence.SQLiteRepositoryImpl;
import pokedex.domain.Pokedex;
import pokedex.domain.PokedexRepository;
import pokedex.domain.PokedexesCollection;

import java.util.List;

final public class PokedexRepositoryImpl extends SQLiteRepositoryImpl implements PokedexRepository {

    public PokedexesCollection findAll() {
        List<String[]> rowset = executeQuery("select pokedex_id, name, description\n"
            + "from pokedex_prose\n"
            + "where local_language_id = 9");

        return buildPokedexes(rowset);
    }

    private PokedexesCollection buildPokedexes(List<String[]> rowset) {
        PokedexesCollection pokedexes = new PokedexesCollection();
        for (String[] row : rowset) {
            Pokedex pokedex = new Pokedex();
            pokedex.setId(row[0]);
            pokedex.setName(row[1]);
            pokedex.setDescription(row[2]);

            pokedexes.add(pokedex);
        }

        return pokedexes;
    }
}
