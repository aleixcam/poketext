package shared.type.infrastructure.persistence.SQLite;

import shared.core.infrastructure.Persistence.SQLite.SQLiteManager;
import shared.type.domain.Type;
import shared.type.domain.TypeRepository;

import java.util.Map;

final public class SQLiteTypeRepository implements TypeRepository {

    private final SQLiteManager repository;

    public SQLiteTypeRepository(SQLiteManager repository) {
        this.repository = repository;
    }

    public int getDamageFactor(Type attacking, Type defending) {
        Map<String, Object> result = repository.executeQuery("select damage_factor\n"
                + "from type_efficacy\n"
                + "where damage_type_id = " + attacking.value() + "\n"
                + "and target_type_id = " + defending.value()).get(0);

        return (int) result.get("damage_factor");
    }
}
