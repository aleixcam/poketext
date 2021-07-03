package shared.core.infrastructure.Persistence.FileSystem;

import java.io.*;
import java.util.*;

public abstract class FileSystemManager<T> {

    protected String directory;

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    protected String[] read(String ref) {
        List<String> data = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(getPath(ref)));

            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }

            br.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        return data.toArray(new String[0]);
    }

    protected void write(String ref, String[] data) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(getPath(ref), false));

            for (String line : data) {
                pw.println(line);
            }

            pw.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

     public void erase(String ref) {
        try {
            File file = new File(ref);
            if (!file.delete()) {
                throw new IOException("Can't erase file: " + ref);
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

    abstract public T importOne(String ref);
    abstract public T[] importMany(String ref);
    abstract public void exportOne(String ref, T data);
    abstract public void exportMany(String ref, T[] data);
}
