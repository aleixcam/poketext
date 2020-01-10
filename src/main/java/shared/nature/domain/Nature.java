package shared.nature.domain;

import shared.core.domain.Service.SilentObjectCreator;
import java.util.Map;

final public class Nature {

    private int id;
    private String name;
    private int increasedStat;
    private int decreasedStat;

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public int increasedStat() {
        return increasedStat;
    }

    public int decreasedStat() {
        return decreasedStat;
    }

    public static Nature instance(Map<String, Object> map) {
        Nature nature = SilentObjectCreator.create(Nature.class);
        nature.id = (int) map.get("id");
        nature.name = (String) map.get("name");
        nature.increasedStat = (int) map.get("increased_stat_id");
        nature.decreasedStat = (int) map.get("decreased_stat_id");

        return nature;
    }
}
