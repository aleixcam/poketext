package indexer.move.infrastructure.controller;

import shared.application.search.Searcher;
import indexer.move.application.GetMoves.GetMovesRequest;
import indexer.move.application.GetMoves.GetMovesUseCase;
import indexer.move.infrastructure.injector.MoveApplicationInjector;
import shared.infrastructure.printer.MatrixPrinter;

final public class MoveController implements Searcher {

    private String nameFilter = "";
    private String typeFilter = "";

    public MoveController() {
        search();
    }

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
        this.typeFilter = "";
        search();
    }

    private GetMovesUseCase<String[][]> getMovesUseCase() {
        return MoveApplicationInjector.injectGetMovesUseCase();
    }
}
