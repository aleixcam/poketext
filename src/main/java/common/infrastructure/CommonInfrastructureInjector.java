package common.infrastructure;

import common.infrastructure.persistence.SQLiteRepository;

public class CommonInfrastructureInjector {

    public static SQLiteRepository injectSQLiteRepository() {
        return new SQLiteRepository();
    }
}
