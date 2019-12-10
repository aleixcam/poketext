package indexer.pokedex.infrastructure.persistence.SQLite;

import shared.domain.SQLiteRepository;
import indexer.pokedex.domain.Pokedex;
import indexer.pokedex.domain.PokedexRepository;
import indexer.pokedex.domain.PokedexCollection;

import java.util.List;

final public class PokedexRepositoryImpl implements PokedexRepository {

    private final SQLiteRepository repository;

    public PokedexRepositoryImpl(SQLiteRepository repository) {
        this.repository = repository;
    }

    public PokedexCollection findAll() {
        List<String[]> list = repository.executeQuery("select pokedex_id, name, description\n"
            + "from pokedex_prose\n"
            + "where local_language_id = 9");

        return buildPokedexes(list);
    }

    private PokedexCollection buildPokedexes(List<String[]> list) {
        PokedexCollection pokedexes = new PokedexCollection();
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
