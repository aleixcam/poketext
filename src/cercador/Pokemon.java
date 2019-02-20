package cercador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import infrastructure.persistence.sqlite.SQLiteRepository;
import poketext.Connector;
import static poketext.Opcions.lang;

public class Pokemon {

    //**************************************************************************
    //****STATS*****************************************************************
    //**************************************************************************
    // Consultar les estadístiques d'un Pokèmon
    private static ResultSet consultarStatsBase(String id) throws SQLException {
        ResultSet result;
        PreparedStatement st = Connector.connect.prepareStatement("select"
                + "     (select s.base_stat\n"
                + "	from pokemon_stats s\n"
                + "	where p.id = s.pokemon_id\n"
                + "	and s.stat_id = 1)  'hp',\n"
                + "	(select s.base_stat\n"
                + "	from pokemon_stats s\n"
                + "	where p.id = s.pokemon_id\n"
                + "	and s.stat_id = 2)  'atk',\n"
                + "	(select s.base_stat\n"
                + "	from pokemon_stats s\n"
                + "	where p.id = s.pokemon_id\n"
                + "	and s.stat_id = 3)  'def',\n"
                + "	(select s.base_stat\n"
                + "	from stat_names n, pokemon_stats s\n"
                + "	where p.id = s.pokemon_id\n"
                + "	and s.stat_id = 4)  'spatk',\n"
                + "	(select s.base_stat\n"
                + "	from pokemon_stats s\n"
                + "	where p.id = s.pokemon_id\n"
                + "	and s.stat_id = 5)  'spdef',\n"
                + "	(select s.base_stat\n"
                + "	from pokemon_stats s\n"
                + "	where p.id = s.pokemon_id\n"
                + "	and s.stat_id = 6)  'spe'\n"
                + "from pokemon p\n"
                + "where p.id = " + id);
        result = st.executeQuery();
        return result;
    }

    public static int[] obtenirStatsBase(String id) throws SQLException {
        int[] base = new int[6];
        ResultSet result = consultarStatsBase(id);
        base[0] = result.getInt("hp");
        base[1] = result.getInt("atk");
        base[2] = result.getInt("def");
        base[3] = result.getInt("spatk");
        base[4] = result.getInt("spdef");
        base[5] = result.getInt("spe");
        return base;
    }

    //**************************************************************************
    //****POKEMONS**************************************************************
    //**************************************************************************
    // Fer una consulta a la base de dades sobre el pokemons
    public static String[][] consultarPokemon(String filter_name, String filter_type, String pokedex) throws SQLException {
        String type_dex = "d.pokedex_number";
        String type_def = "1";
        if (pokedex.equals("1")) {
            type_dex = "p.id";
            type_def = "'%%'";
        }

        String[] col = {"ID", "Nom", "Tipus 1", "Tipus 2", "HP", "Atk", "Def", "SpA", "SpD", "Spe"};
        ResultSet result;
        PreparedStatement st = Connector.connect.prepareStatement("select " + type_dex + " 'id', p.identifier 'name',\n"
                + "	(select n.name\n"
                + "	from type_names n, pokemon_types t\n"
                + "	where n.type_id = t.type_id\n"
                + "	and p.id = t.pokemon_id\n"
                + "	and n.local_language_id = " + lang + "\n"
                + "	and t.slot = 1)  'type_one',\n"
                + "	(select n.name\n"
                + "	from type_names n, pokemon_types t\n"
                + "	where n.type_id = t.type_id\n"
                + "	and p.id = t.pokemon_id\n"
                + "	and n.local_language_id = " + lang + "\n"
                + "	and t.slot = 2)  'type_two',\n"
                + "	(select s.base_stat\n"
                + "	from pokemon_stats s\n"
                + "	where p.id = s.pokemon_id\n"
                + "	and s.stat_id = 1)  'hp',\n"
                + "	(select s.base_stat\n"
                + "	from pokemon_stats s\n"
                + "	where p.id = s.pokemon_id\n"
                + "	and s.stat_id = 2)  'atk',\n"
                + "	(select s.base_stat\n"
                + "	from pokemon_stats s\n"
                + "	where p.id = s.pokemon_id\n"
                + "	and s.stat_id = 3)  'def',\n"
                + "	(select s.base_stat\n"
                + "	from pokemon_stats s\n"
                + "	where p.id = s.pokemon_id\n"
                + "	and s.stat_id = 4)  'spatk',\n"
                + "	(select s.base_stat\n"
                + "	from pokemon_stats s\n"
                + "	where p.id = s.pokemon_id\n"
                + "	and s.stat_id = 5)  'spdef',\n"
                + "	(select s.base_stat\n"
                + "	from pokemon_stats s\n"
                + "	where p.id = s.pokemon_id\n"
                + "	and s.stat_id = 6)  'spe'\n"
                + "from pokemon p, pokemon_dex_numbers d\n"
                + "where p.species_id = d.species_id\n"
                + "and d.pokedex_id = " + pokedex + "\n"
                + "and p.is_default like " + type_def + "\n"
                + "and p.identifier like '%" + filter_name + "%'\n"
                + "and  (type_one like '%" + filter_type + "%' or type_two like '%" + filter_type + "%')\n"
                + "order by " + type_dex);
        result = st.executeQuery();
        return SQLiteRepository.resultSetToMatrix(result, col);
    }
}
