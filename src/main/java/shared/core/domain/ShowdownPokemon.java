package shared.core.domain;

import shared.pokemon.domain.Stat;

import java.util.Map;

public class ShowdownPokemon {

    private final String name;
    private final String nickname;
    private final char gender;
    private final String item;
    private final String ability;
    private final int level;
    private final boolean shiny;
    private final Map<Stat, Integer> effortValues;
    private final String nature;
    private final Map<Stat, Integer> individualValues;
    private final String[] moves;

    public ShowdownPokemon(
        String name,
        String nickname,
        char gender,
        String item,
        String ability,
        int level,
        boolean shiny,
        Map<Stat, Integer> effortValues,
        String nature,
        Map<Stat, Integer> individualValues,
        String[] moves
    ) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public char getGender() {
        return gender;
    }

    public String getItem() {
        return item;
    }

    public String getAbility() {
        return ability;
    }

    public int getLevel() {
        return level;
    }

    public boolean isShiny() {
        return shiny;
    }

    public Map<Stat, Integer> getEffortValues() {
        return effortValues;
    }

    public String getNature() {
        return nature;
    }

    public Map<Stat, Integer> getIndividualValues() {
        return individualValues;
    }

    public String[] getMoves() {
        return moves;
    }
}
