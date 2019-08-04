package indexer.item.application;

import indexer.item.domain.ItemsCollection;

public interface ItemTransformer {

    String[][] assemble(ItemsCollection items);
}
