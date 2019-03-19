package infrastructure.persistence.CSV;

import infrastructure.presentation.reader.StreamReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Fitxers {

    // Llegir un fitxer i enmagatzemar les dades en un array
    public static String[] llegirFitxer(String url) throws IOException {
        FileReader fr = new FileReader(url);
        List<String> arr;
        try (BufferedReader br = new BufferedReader(fr)) {
            arr = new ArrayList<>();
            String fila;
            while ((fila = br.readLine()) != null) {
                arr.add(fila);
            }
        }
        String[] res = new String[arr.size()];
        res = arr.toArray(res);
        return res;
    }

    // Escriure les dades d'un array
    public static void escriureFitxer(String[] dades, String url) throws IOException {
        FileWriter fw = new FileWriter(url, false);
        try (PrintWriter pw = new PrintWriter(fw)) {
            for (String fila : dades) {
                pw.println(fila);
            }
        }
    }

    // Eliminar un fitxer
    public static void eliminarFitxer(String url) {
        File fitxer = new File(url);
        fitxer.delete();
    }

    // Llistar fitxers dins d'un directori
    private static void llistarDirectori(String dir) {
        File f = new File(dir);
        boolean sortir = false;

        do {
            if (f.exists()) {
                File[] fitxers = f.listFiles();
                if (fitxers != null) {
                    for (File fitxer : fitxers) {
                        System.out.println(fitxer.getName());
                    }
                }

                sortir = true;
            } else {
                f.mkdir();
            }
        } while (!sortir);
    }

    // Obtenir la URL d'un fitxer
    public static String obtenirURL(String dir) throws IOException {
        String url;
        System.out.println("Fitxers desats:");
        llistarDirectori(dir);
        System.out.println();
        url = String.format("%s/%s", dir, StreamReader.read());
        System.out.println("Has seleccionat '" + url + "'");
        return url;
    }
}
