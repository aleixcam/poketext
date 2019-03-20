package infrastructure.service;

import java.util.ArrayList;
import java.util.List;

public class ConvertCSVService {

    public static String[] toCSV(String[][] matrix, String comma) {
        List<String> data = new ArrayList<>();

        for (String[] row : matrix) {
            StringBuilder sb = new StringBuilder(row[0]);
            for (int i = 1; i < row.length ; i++) {
                sb.append(comma).append(row[i]);
            }
            data.add(sb.toString());
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
