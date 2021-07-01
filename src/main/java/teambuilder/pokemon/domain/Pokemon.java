package teambuilder.pokemon.domain;

import shared.ability.domain.Ability;
import shared.item.domain.Item;
import shared.move.domain.MoveCollection;
import shared.nature.domain.Nature;
import shared.pokemon.domain.EffortValues;
import shared.pokemon.domain.Gender;
import shared.pokemon.domain.IndividualValues;
import shared.pokemon.domain.Level;

public final class Pokemon {

    public static class BasePokemon extends shared.pokemon.domain.Pokemon {}

    private final BasePokemon basePokemon;
    private final String nickname;
    private final Gender gender;
    private final Item item;
    private final Ability ability;
    private final Level level;
    private final boolean shiny;
    private final EffortValues effortValues;
    private final Nature nature;
    private final IndividualValues individualValues;
    private final MoveCollection moves;

    public Pokemon(
            BasePokemon basePokemon,
            String nickname,
            Gender gender,
            Item item,
            Ability ability,
            Level level,
            boolean shiny,
            EffortValues effortValues,
            Nature nature,
            IndividualValues individualValues,
            MoveCollection moves
    ) {
        this.basePokemon = basePokemon;
        this.nickname = nickname;
        this.gender = gender;
        this.item = item;
        this.ability = ability;
        this.level = level;
        this.shiny = shiny;
        this.effortValues = effortValues;
        this.nature = nature;
        this.individualValues = individualValues;
        this.moves = moves;
    }

    public BasePokemon getBasePokemon() {
        return basePokemon;
    }

    public String getNickname() {
        return nickname;
    }

    public Item getItem() {
        return item;
    }

    public Ability getAbility() {
        return ability;
    }

    public Level getLevel() {
        return level;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isShiny() {
        return shiny;
    }

    public EffortValues getEffortValues() {
        return effortValues;
    }

    public Nature getNature() {
        return nature;
    }

    public IndividualValues getIndividualValues() {
        return individualValues;
    }

    public MoveCollection getMoves() {
        return moves;
    }
}
