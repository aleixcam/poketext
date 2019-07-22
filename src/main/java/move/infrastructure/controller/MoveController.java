package move.infrastructure.controller;

import common.application.search.Searcher;
import move.application.GetMoves.GetMovesRequest;
import move.application.GetMoves.GetMovesUseCase;
import move.infrastructure.injector.MoveApplicationInjector;
import common.infrastructure.printer.MatrixPrinter;
import common.infrastructure.service.ReaderService;

public class MoveController implements Searcher {

    private String nameFilter = "";
    private String typeFilter = "";

    private void search() {
        String[][] moves = getMovesUseCase().execute(
            new GetMovesRequest(nameFilter, typeFilter)
        );

        System.out.printf("Nom: %s Tipus: %s%n", nameFilter, typeFilter);
        MatrixPrinter.print(moves);
        System.out.printf("Nom: %s Tipus: %s%n", nameFilter, typeFilter);
    }

    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
        search();
    }

    public void setTypeFilter(String typeFilter) {
        this.typeFilter = typeFilter;
        search();
    }

    public void removeNameFilter() {
        this.nameFilter = "";
        search();
    }

    public void removeTypeFilter() {
        this.nameFilter = "";
        search();
    }

    private GetMovesUseCase getMovesUseCase() {
        return MoveApplicationInjector.injectGetMovesUseCase();
    }

    public static void viewMoves() {
        String filter_type = "";
        String filter_name = "";
        String[] s;
        boolean sortir = false;
        
        do {

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
