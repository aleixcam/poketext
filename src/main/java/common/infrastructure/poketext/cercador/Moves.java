package infrastructure.poketext.cercador;

import move.application.GetMoves.GetMovesUseCase;
import move.infrastructure.MoveRepositorySQLite;
import infrastructure.presentation.printer.MatrixPrinter;
import infrastructure.service.ReaderService;
import infrastructure.presentation.transformer.matrix.MoveAssemblerMatrix;

public class Moves {

    public static void viewMoves() {
        String filter_type = "";
        String filter_name = "";
        String[] s;
        boolean sortir = false;
        
        do {

            GetMovesUseCase service = new GetMovesUseCase(new MoveRepositorySQLite(), new MoveAssemblerMatrix());
            String[][] moves = service.execute(0, filter_name, filter_type);

            // Mostrar per pantalla els moviments
            System.out.printf("Nom: %s Tipus: %s%n", filter_name, filter_type);
            MatrixPrinter.print(moves);
            System.out.printf("Nom: %s Tipus: %s%n", filter_name, filter_type);

            // Opcions del menú
            System.out.printf("%nCERCADOR: MOVIMENTS%n");
            System.out.println("N. Filtrar per nom");
            System.out.println("T. Filtrar per tipus");
            System.out.println("E. Eliminar filtre");
            System.out.println("Q. Sortir");
            s = ReaderService.read().split(" ");

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
    }
}
