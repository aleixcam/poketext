package showndown.type.infrastructure.persistence.SQLite;

import org.apache.commons.lang3.math.NumberUtils;
import shared.domain.SQLiteRepository;
import showndown.type.domain.Type;
import showndown.type.domain.TypeRepository;

final public class TypeRepositoryImpl implements TypeRepository {

    private final SQLiteRepository repository;

    public TypeRepositoryImpl(SQLiteRepository repository) {
        this.repository = repository;
    }

    public int getDamageFactor(Type attacking, Type defending) {
        String[] result = repository.executeQuery("select damage_factor\n"
                + "from type_efficacy\n"
                + "where damage_type_id = " + attacking.value() + "\n"
                + "and target_type_id = " + defending.value()).get(0);

        return NumberUtils.isParsable(result[0]) ? Integer.parseInt(result[0]) : 100;
    }
}
