package shared.core.infrastructure.Persistence.FileSystem;

import shared.core.infrastructure.Transformer.FileSystemCSVTransformer;

import java.util.List;

public class CSVFileSystemManager extends FileSystemManager<String[][]> {

    public final FileSystemCSVTransformer transformer;

    public CSVFileSystemManager(FileSystemCSVTransformer csvService) {
        this.transformer = csvService;
    }

    protected String[][] importData(List<String> data) {
        return this.transformer.toCSV(data.toArray(new String[0]));
    }

    protected String[] exportData(String[][] csv) {
        return this.transformer.fromCSV(csv);
    }
}
