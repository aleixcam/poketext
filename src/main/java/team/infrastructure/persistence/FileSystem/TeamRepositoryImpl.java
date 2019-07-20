package team.infrastructure.persistence.FileSystem;

import common.domain.CSVService;
import common.infrastructure.persistence.FileSystemRepositoryImpl;

import java.util.List;

final public class TeamRepositoryImpl extends FileSystemRepositoryImpl<String[][][]> {

    public TeamRepositoryImpl(CSVService csvService) {
        this.csvService = csvService;
        this.directory = "data/memory/team";
    }

    @Override
    protected String[][][] build(List<String> csv) {
        return csvService.fromCSV3(csv.toArray(new String[0]));
    }

    @Override
    protected String[] getCSV(String[][][] team) {
        return csvService.toCSV3(team);
    }
}
