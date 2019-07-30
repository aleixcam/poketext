package item.infrastructure.persistence.SQLite;

import shared.domain.SQLiteRepository;
import item.domain.Item;
import item.domain.ItemCriteria;
import item.domain.ItemRepository;
import item.domain.ItemsCollection;
import shared.infrastructure.service.LanguageService;

import java.util.List;
import java.util.Objects;

final public class ItemRepositoryImpl implements ItemRepository {

    private final SQLiteRepository repository;

    public ItemRepositoryImpl(SQLiteRepository repository) {
        this.repository = repository;
    }

    public ItemsCollection findByCriteria(ItemCriteria criteria) {
        List<String[]> list = repository.executeQuery("select i.id, n.name, f.flavor_text\n"
                + "from items i, item_categories c,  item_names n, item_flavor_text f\n"
                + "where i.category_id = c.id\n"
                + "and i.id = n.item_id\n"
                + "and i.id = f.item_id\n"
                + "and (c.pocket_id = 1\n"
                + "or c.pocket_id = 3\n"
                + "or c.pocket_id = 5)\n"
                + "and n.local_language_id = " + LanguageService.ENGLISH + "\n"
                + "and f.language_id = 9\n"
                + "and f.version_group_id = 15\n"
                + (!Objects.equals(criteria.getName(), "") ? "and n.name like '%" + criteria.getName() + "%'" : ""));

        return buildItems(list);
    }

    private ItemsCollection buildItems(List<String[]> list) {
        ItemsCollection items = new ItemsCollection();
        for (String[] row : list) {
            Item item = new Item();
            item.setId(row[0]);
            item.setName(row[1]);
            item.setDescription(row[2]);

            items.add(item);
        }

        return items;
    }
}
