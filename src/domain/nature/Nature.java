package domain.nature;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Map;

public class Nature {

    private int id;
    private String name;
    private Map<String, Integer> modifiers;

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

    public Map<String, Integer> getModifiers() {
        return modifiers;
    }

    public void setModifiers(Map<String, Integer> modifiers) {
        this.modifiers = modifiers;
    }
}
