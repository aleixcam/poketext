package indexer.item.application.GetItems;

import indexer.item.application.ItemTransformer;
import indexer.item.domain.ItemCriteria;
import indexer.item.domain.ItemRepository;
import indexer.item.domain.ItemsCollection;

public class GetItemsUseCase {

    private ItemRepository repository;
    private ItemTransformer assembler;

    public GetItemsUseCase(ItemRepository repository, ItemTransformer assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public String[][] execute(String name) {
        ItemCriteria criteria = new ItemCriteria();
        criteria.setName(name);

        ItemsCollection items = this.repository.findByCriteria(criteria);
        return this.assembler.assemble(items);
    }
}
