package common.infrastructure;

import common.infrastructure.persistence.SQLiteRepositoryImpl;

final public class CommonInfrastructureInjector {

    public static SQLiteRepositoryImpl injectSQLiteRepository() {
        return new SQLiteRepositoryImpl();
    }
}
