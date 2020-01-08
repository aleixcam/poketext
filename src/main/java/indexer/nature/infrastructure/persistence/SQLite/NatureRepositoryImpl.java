package indexer.nature.infrastructure.persistence.SQLite;

import shared.domain.Service.SQLiteRepository;
import indexer.nature.domain.Nature;
import indexer.nature.domain.NatureRepository;
import indexer.nature.domain.NatureCollection;
import shared.infrastructure.Service.LanguageService;

import java.util.List;
import java.util.Map;

final public class NatureRepositoryImpl implements NatureRepository {

    private final SQLiteRepository repository;

    public NatureRepositoryImpl(SQLiteRepository repository) {
        this.repository = repository;
    }

    public NatureCollection findAll() {
        List<Map<String, Object>> list = repository.executeQuery("select p.id, n.name, p.increased_stat_id, p.decreased_stat_id \n"
            + "from nature_names n, natures p\n"
            + "where p.id = n.nature_id\n"
            + "and local_language_id =" + LanguageService.ENGLISH);

        return buildNatures(list);
    }

    private NatureCollection buildNatures(List<Map<String, Object>> list) {
        NatureCollection natures = new NatureCollection();
        for (Map<String, Object> row : list) {
            natures.add(Nature.instance(row));
        }

        return natures;
    }

    public String getNameById(String id) {
        Map<String, Object> result = repository.executeQuery("select name \n"
            + "from nature_names\n"
            + "where local_language_id = " + LanguageService.ENGLISH + "\n"
            + "and nature_id = " + id).get(0);

        return (String) result.get("name");
    }
}
