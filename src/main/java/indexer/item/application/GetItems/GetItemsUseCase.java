package indexer.item.application.GetItems;

import indexer.item.application.ItemTransformer;
import indexer.item.domain.ItemCriteria;
import indexer.item.domain.ItemRepository;
import indexer.item.domain.ItemCollection;

public class GetItemsUseCase<T> {

    private ItemRepository repository;
    private ItemTransformer<T> transformer;

    public GetItemsUseCase(ItemRepository repository, ItemTransformer<T> transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public T execute(String name) {
        ItemCriteria criteria = new ItemCriteria();
        criteria.setName(name);

        ItemCollection items = this.repository.findByCriteria(criteria);
        return this.transformer.transform(items);
    }
}
