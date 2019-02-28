package domain.pokedex;

import org.apache.commons.lang3.math.NumberUtils;

public class Pokedex {

    private int id;
    private String name;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
