package infrastructure.persistence.SQLite;

import domain.nature.Nature;
import domain.nature.NatureRepository;
import domain.nature.NaturesCollection;
import infrastructure.poketext.Poketext;

import java.util.List;

public class NatureRepositorySQLite extends SQLiteRepository implements NatureRepository {

    public NaturesCollection findAll() {
        List<String[]> rowset = executeQuery("select p.id, n.name, p.increased_stat_id, p.decreased_stat_id \n"
            + "from nature_names n, natures p\n"
            + "where p.id = n.nature_id\n"
            + "and local_language_id =" + Poketext.env.getProperty("languageId"));

        return buildPokedexes(rowset);
    }

    private NaturesCollection buildPokedexes(List<String[]> rowset) {
        NaturesCollection natures = new NaturesCollection();
        for (String[] row : rowset) {
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
        String[] nature = executeQuery("select name \n"
            + "from nature_names\n"
            + "where local_language_id = " + Poketext.env.getProperty("languageId") + "\n"
            + "and nature_id = " + id).get(0);

        return nature[0];
    }
}
