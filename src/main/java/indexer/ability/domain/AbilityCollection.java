package indexer.ability.domain;

import java.util.ArrayList;

public class AbilityCollection {

    private ArrayList<Ability> items = new ArrayList<>();

    public void add(Ability item) {
        items.add(item);
    }

    public ArrayList<Ability> getItems() {
        return items;
    }
}
