package infrastructure.persistence.FileSystem;

import infrastructure.presentation.reader.StreamReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class FileSystemRepository {

    abstract public void delete(String path);

    List<String> read(String path) {
        List<String> data = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }

            br.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        return data;
    }

    void write(String[] data, String path) {
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

     void erase(String path) {
        try {
            File file = new File(path);
            if (!file.delete()) {
                throw new IOException("Can't delete file: " + path);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
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
