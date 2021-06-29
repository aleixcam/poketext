package shared.pokemon.domain;

import shared.core.domain.Service.SilentObjectCreator;
import indexer.pokemon.domain.ValueObject.BaseStats;

import java.util.Map;

public class Pokemon {

    private int id;
    private String name;
    private String typeOne;
    private String typeTwo;
    private BaseStats baseStats;

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String typeOne() {
        return typeOne;
    }

    public String typeTwo() {
        return typeTwo;
    }

    public BaseStats baseStats() {
        return baseStats;
    }

    public static Pokemon instance(Map<String, Object> map) {
        Pokemon ability = SilentObjectCreator.create(Pokemon.class);
        ability.id = (int) map.get("id");
        ability.name = (String) map.get("name");
        ability.typeOne = (String) map.get("type_one");
        ability.typeTwo = (String) map.get("type_two");
        ability.baseStats = (BaseStats) map.get("base_stats");

        return ability;
    }
}
