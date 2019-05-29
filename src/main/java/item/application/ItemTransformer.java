package item.application;

import item.domain.ItemsCollection;

public interface ItemTransformer {

    String[][] assemble(ItemsCollection items);
}
