package infrastructure.persistence.FileSystem;

import java.util.List;

public class TeamRepositoryFileSystem extends FileSystemRepository {

    // final private String DIRECTORY = "team";

    public String[][] findByName(String name) {
        return buildTeam(read(name));
    }

    private String[][] buildTeam(List<String> data) {
        String[] arr = new String[data.size()];
        return importarCSV(data.toArray(arr), ";");
    }

    public void save(String[][] team, String name) {
        write(exportarCSV(team, ";"), name);
    }
}
