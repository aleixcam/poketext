package indexer.ability.domain;

import shared.domain.Service.SilentObjectCreator;
import java.util.Map;

final public class Ability {

    private int id;
    private String name;
    private String effect;

    public Ability(
        int id,
        String name,
        String effect
    ) {
        this.id = id;
        this.name = name;
        this.effect = effect;
    }

    public int id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String effect() {
        return effect;
    }

    public static Ability instance(Map<String, Object> map) {
        Ability ability = SilentObjectCreator.create(Ability.class);
        ability.id = (int) map.get("ability_id");
        ability.name = (String) map.get("name");
        ability.effect = (String) map.get("flavor_text");

        return ability;
    }
}
