package shared.core.infrastructure.Persistence.FileSystem;

import shared.core.infrastructure.Transformer.FileSystemCSVTransformer;

import java.util.List;

public class CSV3FileSystemManager extends FileSystemManager<String[][][]> {

    public final FileSystemCSVTransformer transformer;

    public CSV3FileSystemManager(FileSystemCSVTransformer csvService) {
        this.transformer = csvService;
    }

    protected String[][][] importData(List<String> data) {
        return this.transformer.toCSV3(data.toArray(new String[0]));
    }

    protected String[] exportData(String[][][] csv) {
        return this.transformer.fromCSV3(csv);
    }
}
