package infrastructure.persistence.CSV;

public class TeamRepositoryCSV extends CSVRepository {

    private String comma;

    public TeamRepositoryCSV() {
        this.comma = ";";
    }

    public String[][] findByName(String name) {
        return read(name, comma);
    }
}
