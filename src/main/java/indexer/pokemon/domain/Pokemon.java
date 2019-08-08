package indexer.pokemon.domain;

import org.apache.commons.lang3.math.NumberUtils;

public class Pokemon {

    private int id;
    private String name;
    private String typeOne;
    private String typeTwo;
    private BaseStats baseStats;

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
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public String getTypeOne() {
        return typeOne;
    }

    public void setTypeOne(String type_one) {
        this.typeOne = type_one;
    }

    public String getTypeTwo() {
        return typeTwo;
    }

    public void setTypeTwo(String type_two) {
        this.typeTwo = type_two;
    }

    public BaseStats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(BaseStats base_stats) {
        this.baseStats = base_stats;
    }
}
