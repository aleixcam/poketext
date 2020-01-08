package indexer.ability.domain;

import org.apache.commons.lang3.math.NumberUtils;
import shared.infrastructure.service.SilentObjectCreator;

public class Ability {

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
        return this.name;
    }

    public String effect() {
        return effect;
    }

    public static Ability instance(String[] array) {
        Ability ability = SilentObjectCreator.create(Ability.class);
        ability.id = NumberUtils.isParsable(array[0]) ? Integer.parseInt(array[0]) : 0;
        ability.name = array[1];
        ability.effect = array[2];

        return ability;
    }
}
