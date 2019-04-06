package domain.pokemon;

import org.apache.commons.lang3.math.NumberUtils;

public class Pokemon {

    private int id;
    private String name;
    private String type_one;
    private String type_two;
    private BaseStats base_stats;

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
        return type_one;
    }

    public void setTypeOne(String type_one) {
        this.type_one = type_one;
    }

    public String getTypeTwo() {
        return type_two;
    }

    public void setTypeTwo(String type_two) {
        this.type_two = type_two;
    }

    public BaseStats getBaseStats() {
        return base_stats;
    }

    public void setBaseStats(BaseStats base_stats) {
        this.base_stats = base_stats;
    }
}
