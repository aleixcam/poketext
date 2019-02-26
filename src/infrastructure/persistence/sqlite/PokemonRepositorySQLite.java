package infrastructure.persistence.sqlite;

import domain.pokemon.PokemonRepository;
import infrastructure.transformer.matrix.MatrixAssembler;
import poketext.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static poketext.Opcions.lang;

public class PokemonRepositorySQLite extends SQLiteRepository implements PokemonRepository {

    public String[][] findByCriteria(int pokedex_id, String filter_name, String filter_type) throws SQLException {
        final String type_dex = pokedex_id == 1 ? "p.id" : "d.pokedex_number";

        PreparedStatement st = Connector.connect.prepareStatement("select " + type_dex + " 'id', p.identifier 'name',\n"
            + "(select n.name\n"
            + "from type_names n, pokemon_types t\n"
            + "where n.type_id = t.type_id\n"
            + "and p.id = t.pokemon_id\n"
            + "and n.local_language_id = " + lang + "\n"
            + "and t.slot = 1) 'type_one',\n"
            + "(select n.name\n"
            + "from type_names n, pokemon_types t\n"
            + "where n.type_id = t.type_id\n"
            + "and p.id = t.pokemon_id\n"
            + "and n.local_language_id = " + lang + "\n"
            + "and t.slot = 2) 'type_two',\n"
            + "(select s.base_stat\n"
            + "from pokemon_stats s\n"
            + "where p.id = s.pokemon_id\n"
            + "and s.stat_id = 1) 'hp',\n"
            + "(select s.base_stat\n"
            + "from pokemon_stats s\n"
            + "where p.id = s.pokemon_id\n"
            + "and s.stat_id = 2) 'atk',\n"
            + "(select s.base_stat\n"
            + "from pokemon_stats s\n"
            + "where p.id = s.pokemon_id\n"
            + "and s.stat_id = 3) 'def',\n"
            + "(select s.base_stat\n"
            + "from pokemon_stats s\n"
            + "where p.id = s.pokemon_id\n"
            + "and s.stat_id = 4) 'spatk',\n"
            + "(select s.base_stat\n"
            + "from pokemon_stats s\n"
            + "where p.id = s.pokemon_id\n"
            + "and s.stat_id = 5) 'spdef',\n"
            + "(select s.base_stat\n"
            + "from pokemon_stats s\n"
            + "where p.id = s.pokemon_id\n"
            + "and s.stat_id = 6) 'spe'\n"
            + "from pokemon p, pokemon_dex_numbers d\n"
            + "where p.species_id = d.species_id\n"
            + "and d.pokedex_id = " + pokedex_id + "\n"
            + "and p.identifier like '%" + filter_name + "%'\n"
            + "and (type_one like '%" + filter_type + "%'"
            + "or type_two like '%" + filter_type + "%')\n"
            + (pokedex_id != 1 ? "and p.is_default = 1\n" : "")
            + "order by " + type_dex);

        ResultSet result = st.executeQuery();
        String[] col = {"ID", "Nom", "Tipus 1", "Tipus 2", "HP", "Atk", "Def", "SpA", "SpD", "Spe"};
        return MatrixAssembler.getMatrix(result, col);
    }

    public int[] findStatsByPokemonId(int pokemon_id) {
        List<String[]> rowset = executeQuery("select"
                + "(select s.base_stat\n"
                + "from pokemon_stats s\n"
                + "where p.id = s.pokemon_id\n"
                + "and s.stat_id = 1) 'hp',\n"
                + "(select s.base_stat\n"
                + "from pokemon_stats s\n"
                + "where p.id = s.pokemon_id\n"
                + "and s.stat_id = 2) 'atk',\n"
                + "(select s.base_stat\n"
                + "from pokemon_stats s\n"
                + "where p.id = s.pokemon_id\n"
                + "and s.stat_id = 3) 'def',\n"
                + "(select s.base_stat\n"
                + "from stat_names n, pokemon_stats s\n"
                + "where p.id = s.pokemon_id\n"
                + "and s.stat_id = 4) 'spatk',\n"
                + "(select s.base_stat\n"
                + "from pokemon_stats s\n"
                + "where p.id = s.pokemon_id\n"
                + "and s.stat_id = 5) 'spdef',\n"
                + "(select s.base_stat\n"
                + "from pokemon_stats s\n"
                + "where p.id = s.pokemon_id\n"
                + "and s.stat_id = 6) 'spe'\n"
                + "from pokemon p\n"
                + "where p.id = " + pokemon_id);

        return buildStats(rowset);
    }

    private int[] buildStats(List<String[]> rowset) {
        String[] row = rowset.get(0);
        int[] stats = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            stats[i] = Integer.parseInt(row[i]);
        }

        return stats;
    }
}
