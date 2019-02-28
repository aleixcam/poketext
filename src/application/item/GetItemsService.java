package application.item;

import domain.item.*;

public class GetItemsService {

    private ItemRepository repository;
    private ItemAssembler assembler;

    public GetItemsService(ItemRepository repository, ItemAssembler assembler) {
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
