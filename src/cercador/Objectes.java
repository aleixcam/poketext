package cercador;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import infrastructure.transformer.matrix.MatrixAssembler;
import poketext.Connector;
import static poketext.Opcions.lang;
import utils.Comuna;

public class Objectes {
    
    // Fer una consulta a la base de dades sobre els objectes
    public static String[][] consultarObjectes(String filter_name) throws SQLException {
        String[] col = {"ID", "Nom", "Descripció"};
        ResultSet result;
        PreparedStatement st = Connector.connect.prepareStatement("select i.id, n.name, f.flavor_text\n"
                + "from items i, item_categories c,  item_names n, item_flavor_text f\n"
                + "where i.category_id = c.id\n"
                + "and i.id = n.item_id\n"
                + "and i.id = f.item_id\n"
                + "and (c.pocket_id = 1\n"
                + "or c.pocket_id = 3\n"
                + "or c.pocket_id = 5)\n"
                + "and n.local_language_id = " + lang + "\n"
                + "and f.language_id = 9\n"
                + "and f.version_group_id = 15\n"
                + "and n.name like '%" + filter_name + "%'");
        result = st.executeQuery();
        return MatrixAssembler.getMatrix(result, col);
    }
    
    // Menú del cercador de objectes
    protected static void cercarObjectes() throws IOException {
        String filter_name = "", s[];
        boolean sortir = false;
        
        try {
            do {

                // Mostrar per pantalla els objectes
                System.out.printf("Nom: %s%n", filter_name);
                MatrixAssembler.printQuery(consultarObjectes(filter_name));
                System.out.printf("Nom: %s%n", filter_name);

                // Opcions del menú
                System.out.printf("%nCERCADOR: ITEMS%n");
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
