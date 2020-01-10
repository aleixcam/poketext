package teambuilder.pokemon.domain;

import shared.ability.domain.Ability;
import shared.item.domain.Item;
import teambuilder.pokemon.domain.Collection.MoveCollection;
import teambuilder.pokemon.domain.ValueObject.Gender;
import teambuilder.pokemon.domain.ValueObject.Happiness;
import teambuilder.pokemon.domain.ValueObject.Level;

public final class Pokemon {
    static final class BasePokemon extends shared.pokemon.domain.Pokemon {}

    private int id;
    private String nickname;
    private BasePokemon basePokemon;
    private Item item;
    private Ability ability;
    private Level level;
    private Gender gender;
    private Happiness happiness;
    private boolean shiny;
    private MoveCollection moves;
}
