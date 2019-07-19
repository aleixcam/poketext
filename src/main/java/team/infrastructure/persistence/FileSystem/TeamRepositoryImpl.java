package team.infrastructure.persistence.FileSystem;

import common.domain.CSVService;
import common.infrastructure.persistence.FileSystemRepositoryImpl;
import team.domain.Team;

import java.util.List;

final public class TeamRepositoryImpl extends FileSystemRepositoryImpl<Team> {

    public TeamRepositoryImpl(CSVService csvService) {
        this.csvService = csvService;
        this.directory = "data/memory/team";
    }

    @Override
    protected Team build(List<String> data) {
        return new Team();
    }

    @Override
    protected String[] deconstruct(Team entity) {
        return new String[0];
    }
}
