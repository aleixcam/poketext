package shared.core.infrastructure.Injector;

import shared.core.infrastructure.Persistence.SQLiteRepositoryImpl;
import shared.core.infrastructure.Service.CSVServiceImpl;
import shared.core.infrastructure.Service.MatrixServiceImpl;

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
