package infrastructure.service;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ConvertCSVService {

    private static String toCSV(String[] row) {
        StringBuilder sb = new StringBuilder(row[0]);

        for (int i = 1; i < row.length ; i++) {
            sb.append(',').append(row[i]);
        }

        return sb.toString();
    }

    public static String[] toCSV(String[][] matrix) {
        List<String> data = new ArrayList<>();

        for (String[] row : matrix) {
            data.add(toCSV(row));
        }

        String[] arr = new String[data.size()];
        return data.toArray(arr);
    }

    public static String[] toCSV(String[][][] parallelepiped) {
        List<String> data = new ArrayList<>();

        for (String[][] matrix : parallelepiped) {
            data.add(StringUtils.join(toCSV(matrix), ';'));
        }

        String[] arr = new String[data.size()];
        return data.toArray(arr);
    }

    public static String[][] fromCSV(String[] data, String comma) {
        String[][] matrix = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            matrix[i] = data[i].split(comma);
        }

        return matrix;
    }
}
