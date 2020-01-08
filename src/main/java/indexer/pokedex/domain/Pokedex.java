package indexer.pokedex.domain;

import shared.core.domain.Service.SilentObjectCreator;
import java.util.Map;

final public class Pokedex {

    private int id;
    private String name;
    private String description;

    public int id() {
        return id;
    }

    public String name() {
        return this.name;
    }

    public String description() {
        return description;
    }

    public static Pokedex instance(Map<String, Object> map) {
        Pokedex pokedex = SilentObjectCreator.create(Pokedex.class);
        pokedex.id = (int) map.get("pokedex_id");
        pokedex.name = (String) map.get("name");
        pokedex.description = (String) map.get("description");

        return pokedex;
    }
}
