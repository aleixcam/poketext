package domain.move;

public class Move {

    private int id;
    private String name;
    private String type;
    private String category;
    private int power;
    private int accuracy;
    private int powerPoints;
    private String effect;

    public Move(String[] values) {
        id = Integer.parseInt(values[0]);
        name = values[1];
        type = values[2];
        category = values[3];
        power = Integer.parseInt(values[4]);
        accuracy = Integer.parseInt(values[5]);
        powerPoints = Integer.parseInt(values[6]);
        effect = values[7];
    }

    public String getName() {
        return name;
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
        return power;
    }

    public int getPowerPoints() {
        return powerPoints;
    }

    public String getEffect() {
        return effect;
    }
}
