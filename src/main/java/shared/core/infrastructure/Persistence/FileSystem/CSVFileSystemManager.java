package shared.core.infrastructure.Persistence.FileSystem;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

final public class CSVFileSystemManager extends FileSystemManager<String[][]> {

    private static final String CSV_SEPARATOR = ",";
    private static final String CSV3_SEPARATOR = ";";

    public String[][] importOne(String ref) {
        return this.fromCSV(this.read(ref));
    }

    public String[][][] importMany(String ref) {
        String[] data = this.read(ref);
        String[][][] parallelepiped = new String[data.length][][];

        for (int i = 0; i < data.length; i++) {
            String[] line = data[i].split(CSV3_SEPARATOR);
            for (int j = 0; j < line.length; j++) {
                parallelepiped[i] = this.fromCSV(line);
            }
        }

        return parallelepiped;
    }

    public void exportOne(String ref, String[][] matrix) {
        this.write(ref, this.toCSV(matrix));
    }

    public void exportMany(String ref, String[][][] parallelepiped) {
        ArrayList<String> data = new ArrayList<>();

        for (String[][] matrix : parallelepiped) {
            data.add(StringUtils.join(this.toCSV(matrix), CSV3_SEPARATOR));
        }

        this.write(ref, data.toArray(new String[0]));
    }

    private String[][] fromCSV(String[] csv) {
        String[][] matrix = new String[csv.length][];

        for (int i = 0; i < csv.length; i++) {
            matrix[i] = csv[i].split(CSV_SEPARATOR);
        }

        return matrix;
    }

    private String[] toCSV(String[][] matrix) {
        List<String> data = new ArrayList<>();

        for (String[] row : matrix) {
            StringBuilder sb = new StringBuilder(row[0]);
            for (int i = 1; i < row.length ; i++) {
                sb.append(CSV_SEPARATOR).append(row[i]);
            }
            data.add(sb.toString());
        }

        return data.toArray(new String[0]);
    }
}
