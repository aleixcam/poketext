package shared.infrastructure.persistence;

import shared.domain.Service.CSVService;
import shared.domain.Service.FileSystemRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class FileSystemRepositoryImpl<T> implements FileSystemRepository<T> {

    protected CSVService csvService;
    protected String directory;

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

    public void write(T entity, String name) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(getPath(name), false));

            for (String line : getCSV(entity)) {
                pw.println(line);
            }

            pw.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

     public void erase(String name) {
        try {
            File file = new File(name);
            if (!file.delete()) {
                throw new IOException("Can't erase file: " + name);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public String[] list() {
        ArrayList<String> list = new ArrayList<>();
        File directory = getDirectory(this.directory);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    list.add(file.getName());
                }
            }
        } else {
            createDirectory(this.directory);
        }

        return list.toArray(new String[0]);
    }

    private File getDirectory(String dir) {
        return new File(
            Objects.requireNonNull(
                getClass().getClassLoader().getResource(dir)
            ).getFile()
        );
    }

    private void createDirectory(String dir) {
        boolean created = new File(dir).mkdir();
        if (!created) {
            System.out.printf("Cannot create directory %s%n", dir);
        }
    }

    private File getPath(String file) {
        return getDirectory(String.format("%s/%s", directory, file));
    }

    abstract protected T build(List<String> csv);
    abstract protected String[] getCSV(T entity);
}
