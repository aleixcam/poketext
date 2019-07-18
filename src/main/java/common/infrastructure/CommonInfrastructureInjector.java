package common.infrastructure;

import common.infrastructure.persistence.SQLiteRepositoryImpl;
import common.infrastructure.service.MatrixService;

final public class CommonInfrastructureInjector {

    public static SQLiteRepositoryImpl injectSQLiteRepository() {
        return new SQLiteRepositoryImpl();
    }

    public static MatrixService injectMatrixService() {
        return new MatrixService();
    }
}
