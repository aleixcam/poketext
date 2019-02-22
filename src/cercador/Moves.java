package cercador;

import application.move.GetMoves.GetMovesService;
import infrastructure.persistence.sqlite.MoveRepositorySQLite;
import infrastructure.transformer.matrix.MatrixTransformer;
import utils.Comuna;

import java.io.IOException;

public class Moves {

    // Menú del cercador de moviments
    protected static void viewMoves() {
        String filter_type = "", filter_name = "", s[];
        boolean sortir = false;
        
        try {
            do {
                GetMovesService service = new GetMovesService(new MoveRepositorySQLite());
                String[][] moves = service.execute(0, filter_name, filter_type);

                // Mostrar per pantalla els moviments
                System.out.printf("Nom: %s Tipus: %s%n", filter_name, filter_type);
                MatrixTransformer.printQuery(moves);
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
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
