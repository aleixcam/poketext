package utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Consultes {
    
    // Convertur un ResultSet a String[][]
    public static String[][] desarConsulta(ResultSet result, String[] col) throws SQLException {
        int n = result.getMetaData().getColumnCount();
        List<String[]> taula = new ArrayList<>();
        Object raw;
        taula.add(col);
        while (result.next()) {
            String[] row = new String[n];
            for (int i = 1; i <= n; i++) {
                if ((raw = result.getObject(i)) == null) {
                    raw = "---";
                }
                row[i - 1] = (raw.toString()).replaceAll("\n", " ");
            }
            taula.add(row);
        }

        // Convertir el ArrayList a una Matriu
        String[][] arr = new String[taula.size()][];
        for (int i = 0; i < taula.size(); i++) {
            arr[i] = taula.get(i);
        }
        return arr;
    }

    // Imprimir una consulta
    public static void imprimirConsulta(String[][] consulta) {
        String[] format = new String[consulta[0].length];
        format[0] = "%" + (Comuna.llargariaMaxima(consulta, 0) - 2) + "s";
        for (int i = 1; i < format.length; i++) {
            format[i] = "%-" + Comuna.llargariaMaxima(consulta, i) + "s";
        }
        System.out.printf(format[0], consulta[0][0]);
        for (int i = 1; i < consulta[0].length; i++) {
            System.out.printf(format[i], " | " + consulta[0][i]);
        }
        System.out.println();
        for (int i = 0; i < 96; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 1; i < consulta.length; i++) {
            System.out.print(String.format(format[0], consulta[i][0]));
            for (int j = 1; j < consulta[i].length; j++) {
                System.out.printf(format[j], " | " + consulta[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < 96; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf(format[0], consulta[0][0]);
        for (int i = 1; i < consulta[0].length; i++) {
            System.out.printf(format[i], " | " + consulta[0][i]);
        }
        System.out.println();
    }
}
