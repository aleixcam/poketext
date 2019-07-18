package common.infrastructure.service;

import common.domain.service.MatrixService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatrixServiceImpl implements MatrixService {

    public String[][] generate(String[] columns, int rows) {
        String[][] matrix = new String[rows + 1][columns.length];
        matrix[0] = columns;

        return matrix;
    }

    public String[][] beautify(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] != null ? matrix[i][j].replace("\n", " ") : "---";
            }
        }

        return matrix;
    }

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

        String[][] matrix = new String[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            matrix[i] = list.get(i);
        }

        return matrix;
    }
}
