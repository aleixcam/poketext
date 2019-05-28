package infrastructure.poketext.cercador;

import application.item.GetItems.GetItemsUseCase;
import infrastructure.persistence.SQLite.ItemRepositorySQLite;
import infrastructure.presentation.printer.MatrixPrinter;
import infrastructure.service.ReaderService;
import infrastructure.presentation.transformer.matrix.ItemAssemblerMatrix;

public class Objectes {
    
    public static void cercarObjectes() {
        String filter_name = "";
        String[] s;
        boolean sortir = false;
        
        do {

            GetItemsUseCase service = new GetItemsUseCase(new ItemRepositorySQLite(), new ItemAssemblerMatrix());
            String[][] items = service.execute(filter_name);

            // Mostrar per pantalla els objectes
            System.out.printf("Nom: %s%n", filter_name);
            MatrixPrinter.print(items);
            System.out.printf("Nom: %s%n", filter_name);

            // Opcions del menú
            System.out.printf("%nCERCADOR: ITEMS%n");
            System.out.println("N. Filtrar per nom");
            System.out.println("E. Eliminar filtre");
            System.out.println("Q. Sortir");
            s = ReaderService.read().split(" ");

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