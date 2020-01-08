package indexer.move.domain;

import shared.domain.Service.SilentObjectCreator;
import java.util.Map;

final public class Move {

    private int id;
    private String name;
    private String type;
    private String category;
    private int power;
    private int accuracy;
    private int powerPoints;
    private String effect;

    public int id() {
        return id;
    }

    public String name() {
        return this.name;
    }

    public String type() {
        return type;
    }

    public String category() {
        return category;
    }

    public int power() {
        return power;
    }

    public int accuracy() {
        return accuracy;
    }

    public int powerPoints() {
        return powerPoints;
    }

    public String effect() {
        return effect;
    }

    public static Move instance(Map<String, Object> map) {
        Move move = SilentObjectCreator.create(Move.class);
        move.id = (int) map.get("id");
        move.name = (String) map.get("name");
        move.type = (String) map.get("type");
        move.category = (String) map.get("identifier");
        move.power = (int) map.get("power");
        move.accuracy = (int) map.get("accuracy");
        move.powerPoints = (int) map.get("pp");
        move.effect = (String) map.get("flavor_text");

        return move;
    }
}
