package infrastructure.transformer.matrix;

import utils.Comuna;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class MatrixAssembler {

    String[][] generate(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] != null ? matrix[i][j].replace("\n", " ") : "---";
            }
        }

        return matrix;
    }

    // Convertir un ResultSet a String[][]
    public static String[][] getMatrix(ResultSet result, String[] col) {
        List<String[]> list = new ArrayList<>();

        try {
            int n = result.getMetaData().getColumnCount();
            Object raw;

            list.add(col);
            while (result.next()) {
                String[] row = new String[n];
                for (int i = 1; i <= n; i++) {
                    if ((raw = result.getObject(i)) == null) {
                        raw = "---";
                    }
                    row[i - 1] = (raw.toString()).replaceAll("\n", " ");
                }
                list.add(row);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        // Convertir el ArrayList a una Matriu
        String[][] matrix = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            matrix[i] = list.get(i);
        }

        return matrix;
    }

    // Imprimir una consulta
    public static void printQuery(String[][] query) {
        String[] format = new String[query[0].length];
        format[0] = "%" + (Comuna.llargariaMaxima(query, 0) - 2) + "s";
        for (int i = 1; i < format.length; i++) {
            format[i] = "%-" + Comuna.llargariaMaxima(query, i) + "s";
        }
        System.out.printf(format[0], query[0][0]);
        for (int i = 1; i < query[0].length; i++) {
            System.out.printf(format[i], " | " + query[0][i]);
        }
        System.out.println();
        for (int i = 0; i < 96; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 1; i < query.length; i++) {
            System.out.print(String.format(format[0], query[i][0]));
            for (int j = 1; j < query[i].length; j++) {
                System.out.printf(format[j], " | " + query[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < 96; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf(format[0], query[0][0]);
        for (int i = 1; i < query[0].length; i++) {
            System.out.printf(format[i], " | " + query[0][i]);
        }
        System.out.println();
    }
}
