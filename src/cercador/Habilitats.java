package cercador;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import poketext.Connector;
import static poketext.Opcions.lang;
import utils.Comuna;
import utils.Consultes;

public class Habilitats {

    // Fer una consulta a la base de dades sobre les habilitats
    private static String[][] consultarHabilitats(String filter_name) throws SQLException {
        String[] col = {"ID", "Nom", "Efecte"};
        ResultSet result;
        PreparedStatement st = Connector.connect.prepareStatement("select f.ability_id, n.name, f.flavor_text\n"
                + "from ability_flavor_text f, ability_names n\n"
                + "where f.ability_id = n.ability_id\n"
                + "and f.language_id = " + lang + "\n"
                + "and n.local_language_id = " + lang + "\n"
                + "and f.version_group_id = 16\n"
                + "and n.name like '%" + filter_name + "%'");
        result = st.executeQuery();
        return Consultes.desarConsulta(result, col);
    }

    // Menú del cercador d'habilitats
    protected static void cercarHabilitats() throws IOException {
        String filter_name = "", s[];
        boolean sortir = false;

        try {
            do {

                // Mostrar per pantalla els moviments
                System.out.printf("Nom: %s%n", filter_name);
                Consultes.imprimirConsulta(consultarHabilitats(filter_name));
                System.out.printf("Nom: %s%n", filter_name);

                // Opcions del menú
                System.out.printf("%nCERCADOR: HABILITATS%n");
                System.out.println("N. Filtrar per nom");
                System.out.println("E. Eliminar filtre");
                System.out.println("Q. Sortir");
                s = Comuna.obtenirText().split(" ");

                // Seleccions del menú
                if ((s[0].equalsIgnoreCase("n")) && (s.length == 2)) {
                    filter_name = s[1];
                } else if ((s[0].equalsIgnoreCase("e")) && (s.length == 1)) {
                    filter_name = "";
                } else if ((s[0].equalsIgnoreCase("q")) && (s.length == 1)) {
                    sortir = true;
                } else {
                    System.out.println("Selecció incorrecte");
                }
            } while (!sortir);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
