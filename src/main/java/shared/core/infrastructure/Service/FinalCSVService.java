package shared.core.infrastructure.Service;

import org.apache.commons.lang3.StringUtils;
import shared.core.domain.Service.CSVService;

import java.util.ArrayList;
import java.util.List;

public final class FinalCSVService implements CSVService {

    private static final String CSV_SEPARATOR = ",";
    private static final String CSV3_SEPARATOR = ";";

    public String[] toCSV(String[][] matrix) {
        List<String> data = new ArrayList<>();
        for (String[] row : matrix) {
            StringBuilder sb = new StringBuilder(row[0]);
            for (int i = 1; i < row.length ; i++) {
                sb.append(CSV_SEPARATOR).append(row[i]);
            }
            data.add(sb.toString());
        }

        String[] arr = new String[data.size()];
        return data.toArray(arr);
    }

    public String[] toCSV(String[][][] parallelepiped) {
        List<String> data = new ArrayList<>();
        for (String[][] matrix : parallelepiped) {
            data.add(StringUtils.join(toCSV(matrix), CSV3_SEPARATOR));
        }

        String[] arr = new String[data.size()];
        return data.toArray(arr);
    }

    public String[][] toMatrix(String[] data) {
        String[][] matrix = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            matrix[i] = data[i].split(CSV_SEPARATOR);
        }

        return matrix;
    }

    public String[][][] toParallelepiped(String[] data) {
        String[][][] parallelepiped = new String[data.length][][];
        for (int i = 0; i < data.length; i++) {
            String[] line = data[i].split(CSV3_SEPARATOR);
            for (int j = 0; j < line.length; j++) {
                parallelepiped[i] = toMatrix(line);
            }
        }

        return parallelepiped;
    }
}
