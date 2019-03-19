package infrastructure.persistence.CSV;

import java.util.ArrayList;
import java.util.List;

public abstract class CSVRepository {

    public static String[][] read(String file, String comma) {
        String[] csv = Fitxers.llegirFitxer(file);
        String[][] matrix = new String[csv.length][];
        for (int i = 0; i < csv.length; i++) {
            matrix[i] = csv[i].split(comma);
        }

        return matrix;
    }

    public static String[] exportarCSV(String[][] matrix, String comma) {
        List<String> arr = new ArrayList<>();
        String[] res;
        String csv;

        for (String[] row : matrix) {
            csv = row[0];
            for (int i = 1; i < row.length; i++) {
                csv += comma + row[i];
            }
            arr.add(csv);
        }
        res = new String[arr.size()];

        return arr.toArray(res);
    }

    public static String[][] importarCSV(String[] csv, String comma) {
        String[][] matriu = new String[csv.length][];
        for (int i = 0; i < csv.length; i++) {
            matriu[i] = csv[i].split(comma);
        }

        return matriu;
    }
}
