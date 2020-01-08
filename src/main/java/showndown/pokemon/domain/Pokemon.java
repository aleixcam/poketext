package showndown.pokemon.domain;

import shared.type.domain.Type;

public class Pokemon {

    private int id;
    private Type type;
    private Type subtype;

    public Type type() {
        return type;
    }

    public Type subtype() {
        return subtype;
    }
}
