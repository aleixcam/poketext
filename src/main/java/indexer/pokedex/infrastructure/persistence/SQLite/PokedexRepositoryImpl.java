package indexer.pokedex.infrastructure.persistence.SQLite;

import shared.core.domain.Service.SQLiteRepository;
import indexer.pokedex.domain.Pokedex;
import indexer.pokedex.domain.PokedexRepository;
import indexer.pokedex.domain.PokedexCollection;

import java.util.List;
import java.util.Map;

final public class PokedexRepositoryImpl implements PokedexRepository {

    private final SQLiteRepository repository;

    public PokedexRepositoryImpl(SQLiteRepository repository) {
        this.repository = repository;
    }

    public PokedexCollection findAll() {
        List<Map<String, Object>> list = repository.executeQuery("select pokedex_id, name, description\n"
            + "from pokedex_prose\n"
            + "where local_language_id = 9");

        return buildPokedexes(list);
    }

    private PokedexCollection buildPokedexes(List<Map<String, Object>> list) {
        PokedexCollection pokedexes = new PokedexCollection();
        for (Map<String, Object> row : list) {
            pokedexes.add(Pokedex.instance(row));
        }

        return pokedexes;
    }
}
