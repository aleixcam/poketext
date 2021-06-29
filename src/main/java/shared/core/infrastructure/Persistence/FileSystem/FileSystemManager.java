package shared.core.infrastructure.Persistence.FileSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class FileSystemManager<T> {

    protected String directory;

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public T read(String ref) {
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

        return importData(data);
    }

    public void write(T data, String name) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(getPath(name), false));

            for (String line : exportData(data)) {
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

    abstract protected T importData(List<String> data);
    abstract protected String[] exportData(T data);
}
