package shared.core.infrastructure.Injector;

import shared.core.domain.Service.ShowdownPokemonTransformer;
import shared.core.domain.Service.ShowdownTeamTransformer;
import shared.core.infrastructure.Persistence.FileSystem.CSV3FileSystemManager;
import shared.core.infrastructure.Persistence.FileSystem.CSVFileSystemManager;
import shared.core.infrastructure.Persistence.FileSystem.ShowdownPokemonFileSystemManager;
import shared.core.infrastructure.Persistence.FileSystem.ShowdownTeamFileSystemManager;
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

    public static <T> ShowdownPokemonFileSystemManager<T> showdownPokemonFileSystemManager(
            ShowdownPokemonTransformer<T> transformer
    ) {
        return new ShowdownPokemonFileSystemManager<>(transformer);
    }

    public static <T> ShowdownTeamFileSystemManager<T> showdownTeamFileSystemManager(
            ShowdownTeamTransformer<T> transformer
    ) {
        return new ShowdownTeamFileSystemManager<>(transformer);
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
