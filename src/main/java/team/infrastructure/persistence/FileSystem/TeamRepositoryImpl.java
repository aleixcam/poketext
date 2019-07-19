package team.infrastructure.persistence.FileSystem;

import common.domain.service.CSVService;
import common.infrastructure.persistence.FileSystemRepositoryImpl;

import java.util.List;

final public class TeamRepositoryImpl extends FileSystemRepositoryImpl {

    public TeamRepositoryImpl(CSVService csvService) {
        this.csvService = csvService;
        this.directory = "data/memory/team";
    }

    public String[][][] get(String name) {
        return assembleTeam(read(getPath(name)));
    }

    public void save(String[][][] team, String name) {
        write(csvService.toCSV3(team), getPath(name));
    }

    protected String getPath(String file) {
        return String.format("%s/%s", directory, file);
    }

    private String[][][] assembleTeam(List<String> data) {
        String[] arr = new String[data.size()];
        return csvService.fromCSV3(data.toArray(arr));
    }
}
