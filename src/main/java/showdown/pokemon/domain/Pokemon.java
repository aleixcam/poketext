package showdown.pokemon.domain;

import shared.ability.domain.Ability;
import shared.item.domain.Item;
import shared.type.domain.Type;
import showdown.pokemon.domain.ValueObject.Stats;
import showdown.pokemon.domain.ValueObject.Gender;

public class Pokemon {

    private final String name;
    private final Type primaryType;
    private final Type secondaryType;
    private final int level;
    private final Gender gender;
    private final boolean shiny;
    private final Item item;
    private final Ability ability;
    private final Stats stats;

    public Pokemon(
        String name,
        Type primaryType,
        Type secondaryType,
        int level,
        Gender gender,
        boolean shiny,
        Item item,
        Ability ability,
        Stats stats
    ) {
        this.name = name;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.level = level;
        this.gender = gender;
        this.shiny = shiny;
        this.item = item;
        this.ability = ability;
        this.stats = stats;
    }

    public Type getPrimaryType() {
        return primaryType;
    }

    public Type getSecondaryType() {
        return secondaryType;
    }
}
