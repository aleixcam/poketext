package showndown.move.domain;

import org.apache.commons.lang3.math.NumberUtils;

public class Move {

    private int id;
    private String name;
    private String type;
    private String category;
    private int power;
    private int accuracy;
    private int pp;
    private String effect;

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPp() {
        return pp;
    }

    public String getEffect() {
        return effect;
    }
}
