package indexer.item.domain;

import shared.domain.Service.SilentObjectCreator;
import java.util.Map;

final public class Item {

    private int id;
    private String name;
    private String description;

    public int id() {
        return id;
    }

    public String name() {
        return this.name;
    }

    public String description() {
        return description;
    }

    public static Item instance(Map<String, Object> map) {
        Item item = SilentObjectCreator.create(Item.class);
        item.id = (int) map.get("id");
        item.name = (String) map.get("name");
        item.description = (String) map.get("flavor_text");

        return item;
    }
}
