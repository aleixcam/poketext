package infrastructure.persistence.FileSystem;

import java.util.List;

public class TeamRepositoryFileSystem extends FileSystemRepository {

    // final private String DIRECTORY = "team";

    public String[][] get(String path) {
        return buildTeam(read(path));
    }

    public void save(String[][] team, String path) {
        write(exportarCSV(team, ";"), path);
    }

    public void delete(String path) {
        erase(path);
    }

    private String[][] buildTeam(List<String> data) {
        String[] arr = new String[data.size()];
        return importarCSV(data.toArray(arr), ";");
    }
}
