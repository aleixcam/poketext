package pokemon.infrastructure.controller;

import common.application.search.Searcher;
import pokemon.application.GetPokemons.GetPokemonsRequest;
import pokemon.application.GetPokemons.GetPokemonsUseCase;
import pokemon.infrastructure.injector.PokemonApplicationInjector;
import pokedex.infrastructure.controller.SearchController;
import common.infrastructure.printer.MatrixPrinter;

final public class PokemonController implements Searcher {

    private String nameFilter = "";
    private String typeFilter = "";
    private String[] pokedex;

    public PokemonController() {
        selectPokedex();
    }

    private void search() {
        String[][] pokemons = getPokemonsUseCase().execute(
            new GetPokemonsRequest(pokedex[0], nameFilter, typeFilter)
        );

        System.out.printf("%nPokèdex: %s%n", pokedex[1]);
        System.out.printf("Nom: %s Tipus: %s%n", nameFilter, typeFilter);
        MatrixPrinter.print(pokemons);
        System.out.printf("Nom: %s Tipus: %s%n", nameFilter, typeFilter);
        System.out.printf("Pokèdex: %s%n", pokedex[1]);
    }

    public void selectPokedex() {
        this.pokedex = SearchController.search();
        search();
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

    private GetPokemonsUseCase getPokemonsUseCase() {
        return PokemonApplicationInjector.injectGetPokemonsUseCase();
    }
}
