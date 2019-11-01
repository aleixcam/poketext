package indexer.item.application;

import indexer.item.domain.ItemsCollection;

public interface ItemTransformer<T> {

    T transform(ItemsCollection items);
}
