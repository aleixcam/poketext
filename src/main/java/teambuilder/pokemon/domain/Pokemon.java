package teambuilder.pokemon.domain;

import shared.ability.domain.Ability;
import shared.item.domain.Item;
import shared.nature.domain.Nature;
import teambuilder.pokemon.domain.Collection.*;
import teambuilder.pokemon.domain.ValueObject.*;


public final class Pokemon {

    private static class BasePokemon extends shared.pokemon.domain.Pokemon {}

    private BasePokemon basePokemon;
    private String nickname;
    private Item item;
    private Ability ability;
    private Level level;
    private Gender gender;
    private Happiness happiness;
    private boolean shiny;
    private EffortValues effortValues;
    private Nature nature;
    private IndividualValues individualValues;
    private MoveCollection moves;
}
