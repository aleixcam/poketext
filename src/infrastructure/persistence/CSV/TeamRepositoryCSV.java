package infrastructure.persistence.CSV;

public class TeamRepositoryCSV extends CSVRepository {

    final private String COMMA = ";";
    final private String DIRECTORY = "team";

    public String[][] findByName(String name) {
        return read(name, COMMA);
    }


    public void save(String[][] team, String name) {
        write(team, name, COMMA);
    }
}
