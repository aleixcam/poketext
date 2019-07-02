package common.infrastructure.classes.teambuilder;

import pokemon.application.GetPokemons.GetPokemonsUseCase;
import common.infrastructure.classes.calc.Estadistiques;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pokemon.infrastructure.injector.PokemonApplicationInjector;
import common.infrastructure.printer.MatrixPrinter;
import common.infrastructure.service.ReaderService;
import poketext.infrastructure.Connector;

// Clase de pokèmons del constructor d'equips
public class Pokes {

    //**************************************************************************
    //****ESCOLLIR**************************************************************
    //**************************************************************************
    // Consultar l'ID del Pokemon seleccionat
    private static String consultarIDPoke(String id, boolean sel) throws SQLException {
        ResultSet result;
        String res = "";

        PreparedStatement select = Connector.connection.prepareStatement("select identifier from pokemon where id = '" + id + "'");
        result = select.executeQuery();
        if (sel) {
            if (result.next()) {
                System.out.printf("Has seleccionat a %S!%n", result.getString("identifier"));
                res = id;
            } else {
                System.out.println("No existeix cap Pokèmon amb l'ID seleccionat");
            }
        } else if (result.next()) {
            res = result.getString("identifier");
        }
        return res;
    }

    // Consultar els stats d'un Pokèmon
    private static String consultarGenerePoke(String id) throws SQLException {
        ResultSet result;
        String res = "";

        PreparedStatement select = Connector.connection.prepareStatement("select gender_rate from pokemon_species where id = " + id);
        result = select.executeQuery();
        if (result.next()) {
            res = result.getString("gender_rate");
        }

        if (res.equals("-1")) {
            res = "3";
        } else {
            res = "2";
        }

        return res;
    }

    // Consultar les estadístiques d'un Pokèmon
    private static ResultSet consultarTipusPoke(String id) throws SQLException {
        ResultSet result;
        PreparedStatement st = Connector.connection.prepareStatement("select type_id\n"
                + "from pokemon_types\n"
                + "where pokemon_id = " + id);
        result = st.executeQuery();
        return result;
    }

    private static void obtenirTipusPoke(String[][] poke) throws SQLException {
        int n = 2;
        ResultSet result = consultarTipusPoke(poke[0][0]);
        while (result.next()) {
            poke[0][n] = result.getString("type_id");
            n++;
        }
    }

    // Donar-li un sobrenom a un Pokèmon
    private static String sobrenomPokemon(String id) throws SQLException {
        String sel, res = "";

        do {
            System.out.println("Vols posar-li un sobrenom al teu Pokèmon? (S/N)");
            sel = ReaderService.read();

            if (sel.equalsIgnoreCase("s")) {
                res = ReaderService.read();
            } else if (sel.equalsIgnoreCase("n")) {
                res = consultarIDPoke(id, false);
            } else {
                System.out.println("Selecció incorrecte");
            }
        } while (res.equals(""));
        return res;
    }

    // Escollir un pokèmon per a l'equip
    static String[][] escollirPoke(String[][] poke) {
        String filter_type = "";
        String filter_name = "";
        String[] s;

        do {
            try {

                GetPokemonsUseCase service = PokemonApplicationInjector.injectGetPokemonsUseCase();
                String[][] pokemons = service.execute(1, filter_name, filter_type);

                // Mostrar per pantalla els pokèmons
                System.out.printf("%nNom: %s Tipus: %s%n", filter_name, filter_type);
                MatrixPrinter.print(pokemons);
                System.out.printf("Nom: %s Tipus: %s%n%n", filter_name, filter_type);

                // Opcions del menú
                System.out.println("S. Seleccionar ID");
                System.out.println("N. Filtrar per nom");
                System.out.println("T. Filtrar per tipus");
                System.out.println("E. Eliminar filtre");
                s = ReaderService.read().split(" ");

                // Seleccions del menú
                if ((s[0].equalsIgnoreCase("s")) && (s.length == 2)) {
                    poke[0][0] = consultarIDPoke(s[1], true);
                    if (!poke[0][0].equals("")) {
                        obtenirTipusPoke(poke);
                        poke[1][1] = consultarGenerePoke(poke[0][0]);
                        poke[1][5] = Detalls.consultarIDHabilitat("1", poke[0][0]);
                        Estadistiques.calcularEstadistiques(poke);
                        poke[0][1] = sobrenomPokemon(poke[0][0]);
                    }
                } else if ((s[0].equalsIgnoreCase("n")) && (s.length == 2)) {
                    filter_name = s[1];
                } else if ((s[0].equalsIgnoreCase("t")) && (s.length == 2)) {
                    filter_type = s[1];
                } else if ((s[0].equalsIgnoreCase("e")) && (s.length == 2)) {
                    if (s[1].equalsIgnoreCase("n")) {
                        filter_name = "";
                    } else if (s[1].equalsIgnoreCase("t")) {
                        filter_type = "";
                    }
                } else {
                    System.out.println("Selecció incorrecte");
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        } while (poke[0][0].equals(""));
        return poke;
    }

    //**************************************************************************
    //****EDITAR****************************************************************
    //**************************************************************************
    // Mostar per pantalla un Pokèmon
    public static void imprimirPoke(String[][] poke) {
        int i, j;
        try {
            System.out.printf("%n%-68s%s%22S%n", "Nom: " + poke[0][1], "Pokèmon:", consultarIDPoke(poke[0][0], false));
            for (j = 0; j <= 48; j++) {
                System.out.print("*");
            }
            System.out.print("* *");
            for (i = 0; i < 28; i++) {
                System.out.print("*");
            }
            System.out.print("* *");
            for (i = 0; i < 14; i++) {
                System.out.print("*");
            }
            System.out.printf("*%n*  %-46s* *  %-26s* *  %s%6s  *%n", "Detalls:", "Moviments:", "HP: ", poke[3][0]);
            System.out.printf("*  %-10s| %-10s| %-10s| %-10s* *", "Nivell", "Genere", "Felicitat", "Shiny");
            for (i = 0; i < 28; i++) {
                System.out.print(" ");
            }
            System.out.printf("* *  %s%6s  *%n", "Atk:", poke[3][1]);
            System.out.printf("*  %-10s| %-10s| %-10s| %-10s* ", poke[1][0], Detalls.consultarGenere(poke[1][1]), poke[1][2], poke[1][3]);
            System.out.printf("*  %-26s* *  %s%6s  *%n*", Moviments.consultarNomMoviment(poke[2][0]), "Def:", poke[3][2]);
            for (i = 0; i < 16; i++) {
                System.out.print(" * ");
            }
            System.out.printf("* *  %-26s* *  %s%6s  *%n", Moviments.consultarNomMoviment(poke[2][1]), "SpA:", poke[3][3]);
            System.out.printf("*  %-22s| %-22s* ", "Objecte:", "Habilitat:");
            System.out.printf("*  %-26s* *  %s%6s  *%n", Moviments.consultarNomMoviment(poke[2][2]), "SpD:", poke[3][4]);
            System.out.printf("*  %-22s| %-22s* ", Detalls.consultarNomObjecte(poke[1][4]), Detalls.consultarNomHabilitat(poke[1][5]));
            System.out.printf("*  %-26s* *  %s%6s  *%n", Moviments.consultarNomMoviment(poke[2][3]), "Spe:", poke[3][5]);
            for (i = 0; i <= 48; i++) {
                System.out.print("*");
            }
            System.out.print("* *");
            for (i = 0; i < 28; i++) {
                System.out.print("*");
            }
            System.out.print("* *");
            for (i = 0; i < 14; i++) {
                System.out.print("*");
            }
            System.out.printf("*%n");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    // Editar un Pokèmon
    static String[][] editarPoke(String[][] poke) {
        boolean sortir = false;
        String sel;

        do {
            imprimirPoke(poke);

            // Opcions del menú
            System.out.printf("%nPOKETEXT: EDITOR DE POKÈMONS%n");
            System.out.println("P. Editar Pokèmon");
            System.out.println("D. Editar detalls");
            System.out.println("M. Editar moviments");
            System.out.println("S. Editar estadístiques");
            System.out.println("F. Finalitzar la edició");
            sel = ReaderService.read();

            // Seleccions del menú
            if (sel.equalsIgnoreCase("p")) {
                escollirPoke(poke);
            } else if (sel.equalsIgnoreCase("d")) {
                Detalls.escollirDetalls(poke);
            } else if (sel.equalsIgnoreCase("m")) {
                Moviments.editarMoviments(poke);
            } else if (sel.equalsIgnoreCase("s")) {
                Stats.escollirStats(poke);
            } else if (sel.equalsIgnoreCase("f")) {
                sortir = true;
            } else {
                System.out.println("Selecció incorrecte");
            }
        } while (!sortir);
        return poke;
    }
}
