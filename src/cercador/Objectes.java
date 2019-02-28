package cercador;

import java.io.IOException;

import application.item.GetItemsService;
import infrastructure.persistence.sqlite.ItemRepositorySQLite;
import infrastructure.transformer.matrix.ItemAssemblerMatrix;
import infrastructure.transformer.matrix.MatrixAssembler;
import utils.Comuna;

public class Objectes {
    
    static void cercarObjectes() throws IOException {
        String filter_name = "";
        String[] s;
        boolean sortir = false;
        
        do {

            GetItemsService service = new GetItemsService(new ItemRepositorySQLite(), new ItemAssemblerMatrix());
            String[][] items = service.execute(filter_name);

            // Mostrar per pantalla els objectes
            System.out.printf("Nom: %s%n", filter_name);
            MatrixAssembler.printQuery(items);
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
    }
}
