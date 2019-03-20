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
    static String[] llegirFitxer(String path) {
        List<String> csv = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            String line;
            while ((line = br.readLine()) != null) {
                csv.add(line);
            }

            br.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        String[] arr = new String[csv.size()];
        return csv.toArray(arr);
    }

    // Escriure les dades d'un array
    public static void escriureFitxer(String[] data, String path) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(path, false));

            for (String line : data) {
                pw.println(line);
            }

            pw.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    // Eliminar un fitxer
    public static boolean eliminarFitxer(String path) {
        File file = new File(path);
        return file.delete();
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
