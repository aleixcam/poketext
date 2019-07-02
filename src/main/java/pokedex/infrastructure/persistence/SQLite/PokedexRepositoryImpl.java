package pokedex.infrastructure.persistence.SQLite;

import common.infrastructure.persistence.SQLiteRepository;
import pokedex.domain.Pokedex;
import pokedex.domain.PokedexRepository;
import pokedex.domain.PokedexesCollection;

import java.util.List;

final public class PokedexRepositoryImpl implements PokedexRepository {

    private final SQLiteRepository repository;

    public PokedexRepositoryImpl(SQLiteRepository repository) {
        this.repository = repository;
    }

    public PokedexesCollection findAll() {
        List<String[]> list = repository.executeQuery("select pokedex_id, name, description\n"
            + "from pokedex_prose\n"
            + "where local_language_id = 9");

        return buildPokedexes(list);
    }

    private PokedexesCollection buildPokedexes(List<String[]> list) {
        PokedexesCollection pokedexes = new PokedexesCollection();
        for (String[] row : list) {
            Pokedex pokedex = new Pokedex();
            pokedex.setId(row[0]);
            pokedex.setName(row[1]);
            pokedex.setDescription(row[2]);

            pokedexes.add(pokedex);
        }

        return pokedexes;
    }
}
