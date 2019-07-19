package common.infrastructure.persistence;

import common.domain.CSVService;
import common.domain.FileSystemRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class FileSystemRepositoryImpl<T> implements FileSystemRepository<T> {

    protected CSVService csvService;
    public String directory;

    public T read(String name) {
        List<String> data = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(getPath(name)));

            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }

            br.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        return build(data);
    }

    public void write(T entity, String path) {
        String[] data = deconstruct(entity);

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


    private String getPath(String file) {
        return String.format("%s/%s", directory, file);
    }

    abstract protected T build(List<String> data);
    abstract protected String[] deconstruct(T entity);
}
