package teambuilder.pokemon.domain;

import shared.ability.domain.Ability;
import shared.item.domain.Item;
import shared.move.domain.MoveCollection;
import shared.type.domain.Type;
import teambuilder.pokemon.domain.ValueObject.Gender;
import teambuilder.pokemon.domain.ValueObject.Happiness;
import teambuilder.pokemon.domain.ValueObject.Level;

public final class Pokemon {

    private int id;
    private String name;
    private Type type;
    private Type subtype;
    private String nickname;
    private Item item;
    private Ability ability;
    private Level level;
    private Gender gender;
    private Happiness happiness;
    private boolean shiny;
    private MoveCollection moves;
}
