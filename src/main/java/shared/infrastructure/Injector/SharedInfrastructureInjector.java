package shared.infrastructure.Injector;

import shared.infrastructure.Persistence.SQLiteRepositoryImpl;
import shared.infrastructure.Service.CSVServiceImpl;
import shared.infrastructure.Service.MatrixServiceImpl;

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
