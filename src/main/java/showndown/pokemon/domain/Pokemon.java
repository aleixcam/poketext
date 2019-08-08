package showndown.pokemon.domain;

import showndown.type.domain.Type;

public class Pokemon {

    private int id;
    private Type typeOne;
    private Type typeTwo;

    public Type getTypeOne() {
        return typeOne;
    }

    public Type getTypeTwo() {
        return typeTwo;
    }
}
