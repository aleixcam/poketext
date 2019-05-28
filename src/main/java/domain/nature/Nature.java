package domain.nature;

import org.apache.commons.lang3.math.NumberUtils;

public class Nature {

    private int id;
    private String name;
    private int increasedStat;
    private int decreasedStat;

    public int getId() {
        return id;
    }

    public void setId(String id) {
        this.id = NumberUtils.isParsable(id) ? Integer.parseInt(id) : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncreasedStat() {
        return increasedStat;
    }

    public void setIncreasedStat(String statId) {
        this.increasedStat = NumberUtils.isParsable(statId) ? Integer.parseInt(statId) : 0;
    }

    public int getDecreasedStat() {
        return decreasedStat;
    }

    public void setDecreasedStat(String statId) {
        this.decreasedStat = NumberUtils.isParsable(statId) ? Integer.parseInt(statId) : 0;
    }
}
