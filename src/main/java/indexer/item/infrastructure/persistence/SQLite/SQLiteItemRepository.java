package indexer.item.infrastructure.persistence.SQLite;

import shared.core.infrastructure.Persistence.SQLite.SQLiteManager;
import shared.item.domain.Item;
import indexer.item.domain.ItemCriteria;
import indexer.item.domain.ItemRepository;
import indexer.item.domain.ItemCollection;
import shared.core.infrastructure.Service.LanguageService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

final public class SQLiteItemRepository implements ItemRepository {

    private final SQLiteManager repository;

    public SQLiteItemRepository(SQLiteManager repository) {
        this.repository = repository;
    }

    public ItemCollection findByCriteria(ItemCriteria criteria) {
        List<Map<String, Object>> list = repository.executeQuery("select i.id, n.name, f.flavor_text\n"
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

    private ItemCollection buildItems(List<Map<String, Object>> list) {
        ItemCollection items = new ItemCollection();
        for (Map<String, Object> row : list) {
            items.add(Item.instance(row));
        }

        return items;
    }
}
