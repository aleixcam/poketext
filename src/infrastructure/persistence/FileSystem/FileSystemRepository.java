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

    static void listDirectory(String dir) {
        File directory = new File(dir);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            }
        } else {
            createDirectory(dir);
        }
    }

    private static boolean createDirectory(String dir) {
        return new File(dir).mkdir();
    }

    // Obtenir la URL d'un fitxer
    public static String obtenirURL(String dir) throws IOException {
        String url;
        System.out.println("Fitxers desats:");
        listDirectory(dir);
        System.out.println();
        url = String.format("%s/%s", dir, StreamReader.read());
        System.out.println("Has seleccionat '" + url + "'");
        return url;
    }
}
