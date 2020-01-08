package teambuilder.pokemon.domain;

import shared.move.domain.MoveCollection;
import shared.type.domain.Type;
import teambuilder.pokemon.domain.ValueObject.Gender;

final public class Pokemon {

    private int id;
    private String name;
    private String nickname;
    private Gender gender;
    private Type type;
    private Type subtype;
    private MoveCollection moves;
}
