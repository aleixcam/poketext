package infrastructure.persistence.FileSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class FileSystemRepository {

    abstract protected String getPath(String file);

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

     public void delete(String path) {
        try {
            File file = new File(path);
            if (!file.delete()) {
                throw new IOException("Can't delete file: " + path);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public String[] listDirectory(String dir) {
        File directory = new File(dir);
        ArrayList<String> list = new ArrayList<>();

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    list.add(file.getName());
                }
            }
        } else {
            createDirectory(dir);
        }

        return list.toArray(new String[0]);
    }

    private void createDirectory(String dir) {
        boolean created = new File(dir).mkdir();
        if (!created) {
            System.out.printf("Cannot create directory %s", dir);
        }
    }
}
