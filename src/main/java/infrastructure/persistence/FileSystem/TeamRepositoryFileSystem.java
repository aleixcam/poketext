package infrastructure.persistence.FileSystem;

import infrastructure.service.ConvertCSVService;

import java.util.List;

public class TeamRepositoryFileSystem extends FileSystemRepository {

    final public String DIRECTORY = "data/memory/team";

    public String[][][] get(String name) {
        return assembleTeam(read(getPath(name)));
    }

    public void save(String[][][] team, String name) {
        write(ConvertCSVService.toCSV3(team), getPath(name));
    }

    protected String getPath(String file) {
        return String.format("%s/%s", DIRECTORY, file);
    }

    private String[][][] assembleTeam(List<String> data) {
        String[] arr = new String[data.size()];
        return ConvertCSVService.fromCSV3(data.toArray(arr));
    }
}
