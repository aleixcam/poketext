package common.infrastructure.classes.calc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pokemon.domain.BaseStats;
import pokemon.infrastructure.injector.PokemonInfrastructureInjector;
import pokemon.infrastructure.persistence.SQLite.PokemonRepositoryImpl;
import poketext.infrastructure.Connector;

public class Estadistiques {

    // Extreure el modificador d'stats de la naturalesa
    private static int[] consultarNaturalesa(String id) throws SQLException {
        int[] natura = new int[2];
        ResultSet result;
        PreparedStatement st = Connector.connection.prepareStatement("select decreased_stat_id, increased_stat_id\n"
                + "from natures where id = " + id);
        result = st.executeQuery();
        natura[0] = result.getInt("decreased_stat_id") - 1;
        natura[1] = result.getInt("increased_stat_id") - 1;
        return natura;
    }

    // Aplicar el modificador d'stats de la naturalesa
    private static double comprovarNaturalesa(int[] natura, int stat) {
        double mod = 1;
        if (natura[0] != natura[1]) {
            if (stat == natura[0]) {
                mod = 0.9;
            } else if (stat == natura[1]) {
                mod = 1.1;
            }
        }
        return mod;
    }

    // Afegir als stats base els IVs i EVs del pokèmon
    private static int calcularStatsBasics(int base, String iv, String ev) {
        return base * 2 + Integer.parseInt(iv) + (Integer.parseInt(ev) / 4);
    }

    // Calcular les estadístiques d'un Pokèmon
    public static void calcularEstadistiques(String[][] poke) {
        int lvl = Integer.parseInt(poke[1][0]);
        int[] natura;

        try {
            PokemonRepositoryImpl repository = PokemonInfrastructureInjector.injectPokemonRepository();
            BaseStats stats = repository.findStatsByPokemonId(Integer.parseInt(poke[0][0]));
            int[] base = {
                stats.getHealth(),
                stats.getAttack(),
                stats.getDefense(),
                stats.getSpecialAttack(),
                stats.getSpecialDefense(),
                stats.getSpeed()
            };

            natura = consultarNaturalesa(poke[4][6]);
            for (int i = 1; i < poke[3].length; i++) {
                poke[3][i] = Long.toString(Math.round((calcularStatsBasics(base[i], poke[5][i], poke[4][i]) * lvl / 100 + 5) * comprovarNaturalesa(natura, i)));
            }
            if (poke[0][0].equals("292")) {
                poke[3][0] = "1";
            } else {
                poke[3][0] = Integer.toString(calcularStatsBasics(base[0], poke[5][0], poke[4][0]) * lvl / 100 + 10 + lvl);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
