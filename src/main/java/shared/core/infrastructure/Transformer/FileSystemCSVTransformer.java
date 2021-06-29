package shared.core.infrastructure.Transformer;

import shared.core.domain.Service.CSVTransformer;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public final class FileSystemCSVTransformer implements CSVTransformer<String[]> {

    public String[][] toCSV(String[] data) {
        String[][] matrix = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            matrix[i] = data[i].split("");
        }

        return matrix;
    }

    public String[][][] toCSV3(String[] data) {
        String[][][] parallelepiped = new String[data.length][][];
        for (int i = 0; i < data.length; i++) {
            String[] line = data[i].split(";");
            for (int j = 0; j < line.length; j++) {
                parallelepiped[i] = toCSV(line);
            }
        }

        return parallelepiped;
    }

    public String[] fromCSV(String[][] matrix) {
        List<String> data = new ArrayList<>();
        for (String[] row : matrix) {
            StringBuilder sb = new StringBuilder(row[0]);
            for (int i = 1; i < row.length ; i++) {
                sb.append(',').append(row[i]);
            }
            data.add(sb.toString());
        }

        String[] arr = new String[data.size()];
        return data.toArray(arr);
    }

    public String[] fromCSV3(String[][][] parallelepiped) {
        List<String> data = new ArrayList<>();
        for (String[][] matrix : parallelepiped) {
            data.add(StringUtils.join(fromCSV(matrix), ';'));
        }

        String[] arr = new String[data.size()];
        return data.toArray(arr);
    }
}
