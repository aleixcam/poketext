package infrastructure.persistence.CSV;

public class PokemonRepositoryCSV extends CSVRepository {

    final private String COMMA = ",";
    final private String DIRECTORY = "pokemon";

    public String[][] findByName(String name) {
        return read(name, COMMA);
    }

    public void save(String[][] pokemon, String name) {
        write(pokemon, name, COMMA);
    }
}
