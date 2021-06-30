package shared.core.infrastructure.Injector;

import shared.core.infrastructure.Persistence.FileSystem.CSV3FileSystemManager;
import shared.core.infrastructure.Persistence.FileSystem.CSVFileSystemManager;
import shared.core.infrastructure.Persistence.FileSystem.ShowdownFileSystemManager;
import shared.core.infrastructure.Persistence.SQLite.SQLiteManager;
import shared.core.infrastructure.Service.FinalCSVService;
import shared.core.infrastructure.Service.MatrixService;
import shared.core.legacy.Connector;
import org.sqlite.JDBC;

final public class SharedInfrastructureInjector {

    public static CSVFileSystemManager csvFileSystemManager() {
        return new CSVFileSystemManager(fileSystemCSVTransformer());
    }

    public static CSV3FileSystemManager csv3FileSystemManager() {
        return new CSV3FileSystemManager(fileSystemCSVTransformer());
    }

    public static <T> ShowdownFileSystemManager<T> showdownFileSystemManager() {
        return new ShowdownFileSystemManager<>();
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

    public static FinalCSVService fileSystemCSVTransformer() {
        return new FinalCSVService();
    }
}
