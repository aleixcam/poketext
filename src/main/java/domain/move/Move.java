package domain.move;

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

    public void setId(String id) {
        this.id = NumberUtils.isParsable(id) ? Integer.parseInt(id) : 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = NumberUtils.isParsable(power) ? Integer.parseInt(power) : 0;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = NumberUtils.isParsable(accuracy) ? Integer.parseInt(accuracy) : 0;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = NumberUtils.isParsable(pp) ? Integer.parseInt(pp) : 0;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
