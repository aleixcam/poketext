package domain.item;

import java.util.ArrayList;

public class ItemsCollection {

    private ArrayList<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
