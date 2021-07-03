package shared.core.infrastructure.Injector;

import shared.core.infrastructure.Persistence.FileSystem.CSVFileSystemManager;
import shared.core.infrastructure.Persistence.FileSystem.ShowdownFileSystemManager;
import shared.core.infrastructure.Persistence.SQLite.SQLiteManager;
import shared.core.infrastructure.Service.MatrixService;
import shared.core.legacy.Connector;
import org.sqlite.JDBC;

final public class SharedInfrastructureInjector {

    public static CSVFileSystemManager csvFileSystemManager() {
        return new CSVFileSystemManager();
    }

    public static ShowdownFileSystemManager showdownFileSystemManager() {
        return new ShowdownFileSystemManager();
    }

    public static SQLiteManager SQLiteManager() {
        return new SQLiteManager(
            new JDBC(),
            Connector.getDatabase()
        );
    }

    public static MatrixService matrixService() {
        return new MatrixService();
    }
}
