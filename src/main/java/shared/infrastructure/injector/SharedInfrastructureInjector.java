package shared.infrastructure;

import shared.infrastructure.persistence.SQLiteRepositoryImpl;
import shared.infrastructure.service.CSVServiceImpl;
import shared.infrastructure.service.MatrixServiceImpl;

final public class SharedInfrastructureInjector {

    public static SQLiteRepositoryImpl injectSQLiteRepository() {
        return new SQLiteRepositoryImpl();
    }

    public static MatrixServiceImpl injectMatrixService() {
        return new MatrixServiceImpl();
    }

    public static CSVServiceImpl injectCSVService() {
        return new CSVServiceImpl();
    }
}
