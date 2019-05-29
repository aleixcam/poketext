package item.application.GetItems;

import item.application.ItemTransformer;
import item.domain.ItemCriteria;
import item.domain.ItemRepository;
import item.domain.ItemsCollection;

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
