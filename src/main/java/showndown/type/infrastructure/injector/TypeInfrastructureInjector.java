package showndown.type.infrastructure.injector;

import shared.infrastructure.injector.SharedInfrastructureInjector;
import showndown.type.infrastructure.persistence.SQLite.TypeRepositoryImpl;

final public class TypeInfrastructureInjector {

    public static TypeRepositoryImpl injectTypeRepository() {
        return new TypeRepositoryImpl(
            SharedInfrastructureInjector.injectSQLiteRepository()
        );
    }
}
