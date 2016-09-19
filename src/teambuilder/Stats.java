package teambuilder;

import calc.Estadistiques;
import cercador.Pokemon;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import poketext.Connector;
import static poketext.Opcions.lang;
import utils.Comuna;

public class Stats {

    //**************************************************************************
    //****NATURALESA************************************************************
    //**************************************************************************
    // Consultar les naturaleses
    private static ResultSet consultarNaturalesa() throws SQLException {
        ResultSet result;
        String res = "";

        PreparedStatement select = Connector.connect.prepareStatement("select p.id, n.name, p.increased_stat_id, p.decreased_stat_id \n"
                + "from nature_names n, natures p\n"
                + "where p.id = n.nature_id\n"
                + "and local_language_id =" + lang);
        result = select.executeQuery();
        return result;
    }

    // Funció per imprimir per pantalla els pokèmons
    public static void imprimirNaturalesa() throws SQLException {
        String[] stats = {"Atk", "Def", "SpA", "SpD", "Spe"};
        String id, name;
        int increased, decreased;
        ResultSet result = consultarNaturalesa();

        System.out.printf("%n%5s | %-8s| %s%n", "ID", "Nom", "Modificadors");
        System.out.println("-----------------------------------------------------------------------------------------------");
        while (result.next()) {
            id = result.getString("id");
            name = result.getString("name");
            increased = result.getInt("increased_stat_id") - 2;
            decreased = result.getInt("decreased_stat_id") - 2;
            System.out.printf("%5s | %-8s| %s%n", id, name, "+" + stats[increased] + ", -" + stats[decreased]);
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("%5s | %-8s| %s%n%n", "ID", "Nom", "Modificadors");
    }

    // Consultar l'ID de la naturalesa seleccionada
    private static String consultarIDNaturalesa(String id) throws SQLException {
        ResultSet result;
        String res = "";

        PreparedStatement select = Connector.connect.prepareStatement("select identifier from natures where id = " + id);
        result = select.executeQuery();
        if (result.next()) {
            res = id;
        } else {
            System.out.println("No existeix cap naturalesa amb l'ID seleccionat");
        }
        return res;
    }

    // Consultar el nom de la naturalesa del Pokèmon
    private static String consultarNomNaturalesa(String id) throws SQLException {
        ResultSet result;
        String res = "";

        PreparedStatement select = Connector.connect.prepareStatement("select name \n"
                + "from nature_names\n"
                + "where local_language_id = " + lang + "\n"
                + "and nature_id = " + id);
        result = select.executeQuery();
        if (result.next()) {
            res = result.getString("name");
        }
        return res;
    }

    // Escollir una naturalesa per al pokèmon
    protected static String escollirNaturalesa() throws IOException {
        String res = "", sel;

        do {
            try {
                imprimirNaturalesa();
                sel = Comuna.obtenirText();
                if ((res = consultarIDNaturalesa(sel)).equals("")) {
                    System.out.println("Selecció incorrecte");
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        } while (res.equals(""));
        return res;
    }

    //**************************************************************************
    //****STATS*****************************************************************
    //**************************************************************************
    // Calcular els EVs restants
    public static int calcularEVsRestants(String[] evs) {
        int suma = 0;
        for (int i = 0; i < 6; i++) {
            suma += Integer.parseInt(evs[i]);
        }
        return 508 - suma;
    }

    // Mostar per pantalla els stats
    private static void imprimirStats(String[][] poke) throws IOException {
        int i, j, base[];
        String noms[] = {"HP", "Attack", "Defense", "Sp. Atk.", "Sp. Def.", "Speed"};
        try {
            base = Pokemon.obtenirStatsBase(poke[0][0]);
            System.out.printf("%n%s%n", "Nom: " + poke[0][1]);
            for (i = 0; i < 37; i++) {
                System.out.print("*");
            }
            System.out.printf("%n*%15s%5s%5s%8s  *", "Base", "EVs", "IVs", "Stats");
            for (i = 0; i < 6; i++) {
                System.out.printf("%n* ");
                for (j = 0; j < 33; j++) {
                    System.out.print("-");
                }
                System.out.printf(" *%n*%10s%5d%5s%5s  |%5s  *", noms[i], base[i], poke[4][i], poke[5][i], poke[3][i]);
            }
            System.out.printf("%n* ");
            for (j = 0; j < 33; j++) {
                System.out.print("-");
            }

            System.out.printf(" *%n*   EVs restants:%4s%16s%n*", calcularEVsRestants(poke[4]), "*");
            for (i = 0; i < 35; i++) {
                System.out.print("*");
            }
            System.out.printf("*%n%s%n", "Naturalesa: " + consultarNomNaturalesa(poke[4][6]));
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    // Escollir un pokèmon per a l'equip
    protected static void escollirStats(String poke[][]) throws IOException {
        boolean sortir = false;
        int evs = 508;
        String s[];

        do {
            Estadistiques.calcularEstadistiques(poke);
            imprimirStats(poke);

            // Opcions del menú
            System.out.printf("%nPOKETEXT: EDITOR DE ESTADÍSTIQUES%n");
            System.out.println("E. Editar EVs (0-252)");
            System.out.println("I. Editar IVs (0-31)");
            System.out.println("N. Seleccionar una naturalesa");
            System.out.println("F. Finalitzar la edició");
            s = Comuna.obtenirText().split(" ");

            // Seleccions del menú
            if ((s[0].equalsIgnoreCase("e")) && (s.length == 3)) {
                if ((Integer.parseInt(s[2]) >= 0) && (Integer.parseInt(s[2]) <= 252)) {
                    if ((poke[0][0].equals("292")) && (s[1].equals("0"))) {
                        System.out.println("Shedinja no pot canviar els seus HP");
                    } else {
                        poke[4][Integer.parseInt(s[1])] = s[2];
                        if (calcularEVsRestants(poke[4]) < 0) {
                            poke[4][Integer.parseInt(s[1])] = "0";
                            System.out.println("No queden prous EVs");
                        }
                    }
                } else {
                    System.out.println("No pots posar la quantitat d'EVs seleccionada");
                }
            } else if ((s[0].equalsIgnoreCase("i")) && (s.length == 3)) {
                if ((Integer.parseInt(s[2]) >= 0) && (Integer.parseInt(s[2]) <= 31)) {
                    poke[5][Integer.parseInt(s[1])] = s[2];
                } else {
                    System.out.println("No pots posar la quantitat d'IVs seleccionada");
                }
            } else if ((s[0].equalsIgnoreCase("n")) && (s.length == 1)) {
                poke[4][6] = escollirNaturalesa();
            } else if ((s[0].equalsIgnoreCase("f")) && (s.length == 1)) {
                sortir = true;
            } else {
                System.out.println("Selecció incorrecte");
            }
        } while (!sortir);
    }
}
