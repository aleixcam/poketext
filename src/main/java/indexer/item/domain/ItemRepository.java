package indexer.item.domain;

public interface ItemRepository {

    ItemCollection findByCriteria(ItemCriteria criteria);
}
