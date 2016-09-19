package cercador;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import poketext.Connector;
import static poketext.Opcions.lang;
import utils.Comuna;
import utils.Consultes;

public class Moves {

    // Fer una consulta a la base de dades sobre els moviments
    public static String[][] consultarMoviments(String id, String filter_name, String filter_type) throws SQLException {
        String[] col = {"ID", "Nom", "Tipus", "Classe", "Pow", "Acc", "PP", "Efecte"};
        ResultSet result;
        PreparedStatement st = Connector.connect.prepareStatement("select distinct(m.id), n.name, t.name, d.identifier, m.power, m.accuracy, m.pp, f.flavor_text\n"
                + "from pokemon_moves p, move_names n, moves m, type_names t, move_flavor_text f, move_damage_classes d\n"
                + "where m.id = p.move_id\n"
                + "and m.id = n.move_id\n"
                + "and t.type_id = m.type_id\n"
                + "and m.id = f.move_id\n"
                + "and p.version_group_id = 16\n"
                + "and m.damage_class_id = d.id\n"
                + "and n.local_language_id = " + lang + "\n"
                + "and t.local_language_id = " + lang + "\n"
                + "and f.language_id = " + lang + "\n"
                + "and p.pokemon_id like '%" + id + "%'\n"
                + "and f.version_group_id = 16\n"
                + "and n.name like '%" + filter_name + "%'\n"
                + "and t.name like '%" + filter_type + "%'\n"
                + "order by m.id");
        result = st.executeQuery();
        return Consultes.desarConsulta(result, col);
    }

    // Manú del cercador de moviments
    protected static void cercarMoves() throws IOException {
        String filter_type = "", filter_name = "", s[];
        boolean sortir = false;
        
        try {
            do {

                // Mostrar per pantalla els moviments
                System.out.printf("Nom: %s Tipus: %s%n", filter_name, filter_type);
                Consultes.imprimirConsulta(consultarMoviments("", filter_name, filter_type));
                System.out.printf("Nom: %s Tipus: %s%n", filter_name, filter_type);

                // Opcions del menú
                System.out.printf("%nCERCADOR: MOVIMENTS%n");
                System.out.println("N. Filtrar per nom");
                System.out.println("T. Filtrar per tipus");
                System.out.println("E. Eliminar filtre");
                System.out.println("Q. Sortir");
                s = Comuna.obtenirText().split(" ");

                // Seleccions del menú
                if ((s[0].equalsIgnoreCase("n")) && (s.length == 2)) {
                    filter_name = s[1];
                } else if ((s[0].equalsIgnoreCase("t")) && (s.length == 2)) {
                    filter_type = s[1];
                } else if ((s[0].equalsIgnoreCase("e")) && (s.length == 2)) {
                    if (s[1].equalsIgnoreCase("n")) {
                        filter_name = "";
                    } else if (s[1].equalsIgnoreCase("t")) {
                        filter_type = "";
                    }
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
