package application.item.GetItems;

import application.item.ItemAssembler;
import domain.item.*;

public class GetItemsUseCase {

    private ItemRepository repository;
    private ItemAssembler assembler;

    public GetItemsUseCase(ItemRepository repository, ItemAssembler assembler) {
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
