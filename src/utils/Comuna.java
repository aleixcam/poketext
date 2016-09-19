package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// Clase de utilitats comunes
public class Comuna {

    // Entrada estàndard
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    // Obtenir un text ben format
    public static String obtenirText() throws IOException {
        System.out.printf("Introdueix una opció: ");
        return (in.readLine().trim()).replaceAll("\\s+", " ");
    }

    // Buscar el String més llarg dins d'un array
    public static int llargariaMaxima(String[][] matriu, int pos) {
        int res = 1;
        for (String[] fila : matriu) {
            if (fila[pos].length() > res) {
                res = fila[pos].length();
            }
        }
        return res + 3;
    }

    // Convertir una matriu a un array en format CSV
    public static String[] exportarCSV(String[][] matriu, String coma) {
        List<String> arr = new ArrayList<>();
        String res[], csv;
        for (String[] fila : matriu) {
            csv = fila[0];
            for (int i = 1; i < fila.length; i++) {
                csv += coma + fila[i];
            }
            arr.add(csv);
        }
        res = new String[arr.size()];
        return arr.toArray(res);
    }

    // Convertir un array en format CSV a una matriu
    public static String[][] importarCSV(String[] csv, String coma) {
        String[][] matriu = new String[csv.length][];
        for (int i = 0; i < csv.length; i++) {
            matriu[i] = csv[i].split(coma);
        }
        return matriu;
    }
}
