package indexer.item.domain;

import java.util.ArrayList;

public class ItemCollection {

    private ArrayList<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
