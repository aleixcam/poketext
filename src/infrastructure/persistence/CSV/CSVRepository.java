package infrastructure.persistence.CSV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CSVRepository {

    abstract public String[][] findByName(String name);

    String[][] read(String path, String comma) {
        String[] csv = Fitxers.llegirFitxer(path);

        String[][] matrix = new String[csv.length][];
        for (int i = 0; i < csv.length; i++) {
            matrix[i] = csv[i].split(comma);
        }

        return matrix;
    }

    void write(String[][] matrix, String path, String comma) {
        List<String> data = new ArrayList<>();

        for (String[] row : matrix) {
            StringBuilder sb = new StringBuilder(row[0]);
            for (int i = 1; i < row.length ; i++) {
                sb.append(comma).append(row[i]);
            }
            data.add(sb.toString());
        }

        String[] arr = new String[data.size()];
        Fitxers.escriureFitxer(data.toArray(arr), path);
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
