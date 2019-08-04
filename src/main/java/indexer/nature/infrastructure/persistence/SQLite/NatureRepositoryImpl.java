package indexer.nature.infrastructure.persistence.SQLite;

import shared.domain.SQLiteRepository;
import indexer.nature.domain.Nature;
import indexer.nature.domain.NatureRepository;
import indexer.nature.domain.NaturesCollection;
import shared.infrastructure.service.LanguageService;

import java.util.List;

final public class NatureRepositoryImpl implements NatureRepository {

    private final SQLiteRepository repository;

    public NatureRepositoryImpl(SQLiteRepository repository) {
        this.repository = repository;
    }

    public NaturesCollection findAll() {
        List<String[]> list = repository.executeQuery("select p.id, n.name, p.increased_stat_id, p.decreased_stat_id \n"
            + "from nature_names n, natures p\n"
            + "where p.id = n.nature_id\n"
            + "and local_language_id =" + LanguageService.ENGLISH);

        return buildPokedexes(list);
    }

    private NaturesCollection buildPokedexes(List<String[]> list) {
        NaturesCollection natures = new NaturesCollection();
        for (String[] row : list) {
            Nature nature = new Nature();
            nature.setId(row[0]);
            nature.setName(row[1]);
            nature.setIncreasedStat(row[2]);
            nature.setDecreasedStat(row[3]);

            natures.add(nature);
        }

        return natures;
    }

    public String getNameById(String id) {
        String[] nature = repository.executeQuery("select name \n"
            + "from nature_names\n"
            + "where local_language_id = " + LanguageService.ENGLISH + "\n"
            + "and nature_id = " + id).get(0);

        return nature[0];
    }
}
