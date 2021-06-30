package shared.core.infrastructure.Persistence.FileSystem;

import shared.core.infrastructure.Service.FinalCSVService;

import java.util.List;

public class CSVFileSystemManager extends FileSystemManager<String[][]> {

    public final FinalCSVService transformer;

    public CSVFileSystemManager(FinalCSVService csvService) {
        this.transformer = csvService;
    }

    protected String[][] importData(List<String> data) {
        return this.transformer.toMatrix(data.toArray(new String[0]));
    }

    protected String[] exportData(String[][] csv) {
        return this.transformer.toCSV(csv);
    }
}
