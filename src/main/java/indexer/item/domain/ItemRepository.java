package indexer.item.domain;

public interface ItemRepository {

    ItemsCollection findByCriteria(ItemCriteria criteria);
}