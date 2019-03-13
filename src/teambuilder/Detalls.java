package teambuilder;

import application.item.GetItems.GetItemsUseCase;
import calc.Estadistiques;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import infrastructure.persistence.sqlite.ItemRepositorySQLite;
import infrastructure.transformer.matrix.ItemAssemblerMatrix;
import infrastructure.transformer.matrix.MatrixAssembler;
import poketext.Connector;
import static poketext.Opcions.lang;
import utils.Comuna;

public class Detalls {

    //**************************************************************************
    //****OBJECTES**************************************************************
    //**************************************************************************
    // Consultar l'ID del objecte seleccionat
    private static String consultarIDObjecte(String id) throws SQLException {
        ResultSet result;
        String res = "";

        PreparedStatement select = Connector.connect.prepareStatement("select name\n"
                + "from item_names\n"
                + "where item_id = " + id + "\n"
                + "and local_language_id = " + lang);
        result = select.executeQuery();
        if (result.next()) {
            res = id;
        } else {
            System.out.println("No existeix cap objecte amb l'ID seleccionat");
        }
        return res;
    }

    // Consultar el nom d'un objecte
    static String consultarNomObjecte(String id) throws SQLException {
        ResultSet result;
        String res = "";

        if (!id.equals("")) {
            PreparedStatement select = Connector.connect.prepareStatement("select name\n"
                    + "from item_names\n"
                    + "where item_id = '" + id + "'\n"
                    + "and local_language_id = " + lang);
            result = select.executeQuery();
            if (result.next()) {
                res = result.getString("name");
            }
        }
        return res;
    }

    // Escollir un pokèmon per a l'equip
    private static String escollirObjecte() throws IOException {
        boolean sortir = false;
        String res = "", filter_name = "", s[];

        do {
            try {

                GetItemsUseCase service = new GetItemsUseCase(new ItemRepositorySQLite(), new ItemAssemblerMatrix());
                String[][] items = service.execute(filter_name);

                // Mostrar per pantalla els pokèmons
                System.out.printf("%nNom: %s%n", filter_name);
                MatrixAssembler.printQuery(items);
                System.out.printf("Nom: %s%n%n", filter_name);

                // Opcions del menú
                System.out.println("S. Seleccionar ID");
                System.out.println("N. Filtrar per nom");
                System.out.println("E. Eliminar filtre");
                System.out.println("Q. Eliminar el objecte");
                s = Comuna.obtenirText().split(" ");

                // Seleccions del menú
                if ((s[0].equalsIgnoreCase("s")) && (s.length == 2)) {
                    res = consultarIDObjecte(s[1]);
                } else if ((s[0].equalsIgnoreCase("n")) && (s.length == 2)) {
                    filter_name = s[1];
                } else if ((s[0].equalsIgnoreCase("e")) && (s.length == 1)) {
                    filter_name = "";
                } else if ((s[0].equalsIgnoreCase("q")) && (s.length == 1)) {
                    sortir = true;
                } else {
                    System.out.println("Selecció incorrecte");
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        } while (res.equals("") && !sortir);
        return res;
    }

    //**************************************************************************
    //****HABILITATS************************************************************
    //**************************************************************************
    // Fer una consulta a la base de dades sobre el pokemons
    private static String[][] consultarHabilitatsPoke(String id) throws SQLException {
        String[] col = {"Slot", "Nom", "Efecte"};
        ResultSet result;
        PreparedStatement st = Connector.connect.prepareStatement("select a.slot, n.name, f.flavor_text\n"
                + "from pokemon_abilities a, ability_names n, ability_flavor_text f\n"
                + "where a.ability_id = n.ability_id\n"
                + "and a.ability_id = f.ability_id\n"
                + "and n.local_language_id = " + lang + "\n"
                + "and f.language_id = " + lang + "\n"
                + "and f.version_group_id = 15\n"
                + "and a.pokemon_id = " + id);
        result = st.executeQuery();
        return MatrixAssembler.getMatrix(result, col);
    }

    // Consultar l'ID del objecte seleccionat
    static String consultarIDHabilitat(String slot, String id) throws SQLException {
        ResultSet result;
        String res = "";

        PreparedStatement select = Connector.connect.prepareStatement("select a.ability_id, n.name\n"
                + "from pokemon_abilities a, ability_names n\n"
                + "where a.ability_id = n.ability_id\n"
                + "and n.local_language_id = " + lang + "\n"
                + "and a.slot = " + slot + "\n"
                + "and a.pokemon_id = " + id);
        result = select.executeQuery();
        if (result.next()) {
            res = result.getString("ability_id");
        } else {
            System.out.println("No existeix cap objecte a l'slot seleccionat");
        }
        return res;
    }

    // Consultar el nom d'un objecte
    static String consultarNomHabilitat(String id) throws SQLException {
        ResultSet result;
        String res = "";

        PreparedStatement select = Connector.connect.prepareStatement("select name\n"
                + "from ability_names\n"
                + "where local_language_id = " + lang + "\n"
                + "and ability_id = " + id);
        result = select.executeQuery();
        if (result.next()) {
            res = result.getString("name");
        }
        return res;
    }

    // Escollir un pokèmon per a l'equip
    private static String escollirHabilitat(String id) throws IOException {
        String res = "", s[];

        do {
            try {

                // Mostrar per pantalla els pokèmons
                System.out.println();
                MatrixAssembler.printQuery(consultarHabilitatsPoke(id));
                System.out.println();

                // Opcions del menú
                System.out.println("S. Seleccionar ID");
                System.out.println("Q. Deixar la habilitat per defecte");
                s = Comuna.obtenirText().split(" ");

                // Seleccions del menú
                if ((s[0].equalsIgnoreCase("s")) && (s.length == 2)) {
                    res = consultarIDHabilitat(s[1], id);
                } else if ((s[0].equalsIgnoreCase("q")) && (s.length == 1)) {
                    res = consultarIDHabilitat("1", id);
                } else {
                    System.out.println("Selecció incorrecte");
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        } while (res.equals(""));
        return res;
    }

    //**************************************************************************
    //****EDITAR****************************************************************
    //**************************************************************************
    // Mostar per pantalla els detalls d'un Pokemon
    private static void imprimirDetalls(String[][] poke) {
        int i, j;
        try {
            System.out.printf("%n%s%n", "Nom: " + poke[0][1]);
            for (j = 0; j <= 48; j++) {
                System.out.print("*");
            }
            System.out.printf("*%n*  %-46s*%n", "Detalls:");
            System.out.printf("*  %-10s| %-10s| %-10s| %-10s*%n", "Nivell", "Genere", "Felicitat", "Shiny");
            System.out.printf("*  %-10s| %-10s| %-10s| %-10s*%n*", poke[1][0], consultarGenere(poke[1][1]), poke[1][2], poke[1][3]);
            for (i = 0; i < 16; i++) {
                System.out.print(" * ");
            }
            System.out.printf("*%n*  %-22s| %-22s*%n", "Objecte:", "Habilitat:");
            System.out.printf("*  %-22s| %-22s*%n", consultarNomObjecte(poke[1][4]), consultarNomHabilitat(poke[1][5]));
            for (i = 0; i <= 48; i++) {
                System.out.print("*");
            }
            System.out.printf("*%n");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    // Consultar el nom del Pokèmon
    static String consultarGenere(String gen) {
        String res;
        switch (gen) {
            case "1":
                res = "Femella";
                break;
            case "2":
                res = "Mascle";
                break;
            default:
                res = "Sense";
                break;
        }
        return res;
    }

    // Escollir un pokèmon per a l'equip
    static void escollirDetalls(String[][] poke) throws IOException {
        boolean sortir = false;

        do {
            imprimirDetalls(poke);

            // Opcions del menú
            System.out.printf("%nPOKETEXT: EDITOR DE DETALLS%n");
            System.out.println("N. Editar el nivell (1-100)");
            System.out.println("G. Editar el genere (M/F)");
            System.out.println("H. Editar la felicitat (0-255)");
            System.out.println("S. Cambiar si es shiny");
            System.out.println("O. Seleccionar un objecte");
            System.out.println("A. Editar la habilitat");
            System.out.println("F. Finalitzar la edició");
            String[] s = Comuna.obtenirText().split(" ");

            // Seleccions del menú
            if ((s[0].equalsIgnoreCase("n")) && (s.length == 2)) {
                if ((Integer.parseInt(s[1]) < 1) || (Integer.parseInt(s[1]) > 100)) {
                    s[0] = "";
                } else {
                    poke[1][0] = s[1];
                    Estadistiques.calcularEstadistiques(poke);
                }
            } else if ((s[0].equalsIgnoreCase("g")) && (s.length == 2) && (!poke[1][1].equals("3"))) {
                if (s[1].equalsIgnoreCase("m")) {
                    poke[1][1] = "2";
                } else if (s[1].equalsIgnoreCase("f")) {
                    poke[1][1] = "1";
                } else {
                    s[0] = "";
                }
            } else if ((s[0].equalsIgnoreCase("h")) && (s.length == 2)) {
                if ((Integer.parseInt(s[1]) < 0) || (Integer.parseInt(s[1]) > 255)) {
                    s[0] = "";
                } else {
                    poke[1][2] = s[1];
                }
            } else if ((s[0].equalsIgnoreCase("s")) && (s.length == 1)) {
                if (Boolean.parseBoolean(poke[1][3])) {
                    poke[1][3] = "false";
                } else {
                    poke[1][3] = "true";
                }
            } else if (s[0].equalsIgnoreCase("o")) {
                poke[1][4] = escollirObjecte();
            } else if (s[0].equalsIgnoreCase("a")) {
                poke[1][5] = escollirHabilitat(poke[0][0]);
            } else if ((s[0].equalsIgnoreCase("f")) && (s.length == 1)) {
                sortir = true;
            } else {
                System.out.println("Selecció incorrecte");
            }
        } while (!sortir);
    }
}
