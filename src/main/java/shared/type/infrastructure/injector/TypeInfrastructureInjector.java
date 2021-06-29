package shared.type.infrastructure.injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import shared.type.infrastructure.persistence.SQLite.SQLiteTypeRepository;

final public class TypeInfrastructureInjector {

    public static SQLiteTypeRepository injectTypeRepository() {
        return new SQLiteTypeRepository(
            SharedInfrastructureInjector.SQLiteManager()
        );
    }
}
