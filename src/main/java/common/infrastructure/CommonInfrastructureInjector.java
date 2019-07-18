package common.infrastructure;

import common.infrastructure.persistence.SQLiteRepositoryImpl;
import common.infrastructure.service.MatrixServiceImpl;

final public class CommonInfrastructureInjector {

    public static SQLiteRepositoryImpl injectSQLiteRepository() {
        return new SQLiteRepositoryImpl();
    }

    public static MatrixServiceImpl injectMatrixService() {
        return new MatrixServiceImpl();
    }
}
