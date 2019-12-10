package indexer.item.application;

import indexer.item.domain.ItemCollection;

public interface ItemTransformer<T> {

    T transform(ItemCollection items);
}
