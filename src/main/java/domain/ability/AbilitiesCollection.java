package domain.ability;

import java.util.ArrayList;

public class AbilitiesCollection {

    private ArrayList<Ability> items = new ArrayList<>();

    public void add(Ability item) {
        items.add(item);
    }

    public ArrayList<Ability> getItems() {
        return items;
    }
}
