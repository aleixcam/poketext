package teambuilder.pokemon.domain;

import shared.ability.domain.Ability;
import shared.item.domain.Item;
import shared.pokemon.domain.Pokemon;
import teambuilder.pokemon.domain.Collection.MoveCollection;
import teambuilder.pokemon.domain.ValueObject.Gender;
import teambuilder.pokemon.domain.ValueObject.Happiness;
import teambuilder.pokemon.domain.ValueObject.Level;

public final class TeamPokemon {

    private int id;
    private String nickname;
    private Pokemon pokemon;
    private Item item;
    private Ability ability;
    private Level level;
    private Gender gender;
    private Happiness happiness;
    private boolean shiny;
    private MoveCollection moves;
}
