package pokemon.infrastructure.controller;

import pokemon.application.GetPokemons.GetPokemonsRequest;
import pokemon.application.GetPokemons.GetPokemonsUseCase;
import pokemon.infrastructure.injector.PokemonApplicationInjector;
import common.infrastructure.classes.cercador.Pokedex;
import common.infrastructure.printer.MatrixPrinter;

final public class PokemonController {

    private String nameFilter = "";
    private String typeFilter = "";
    private String[] pokedex;

    private void execute() {
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
        this.pokedex = Pokedex.cercarPokedex();
        execute();
    }

    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
        execute();
    }

    public void setTypeFilter(String typeFilter) {
        this.typeFilter = typeFilter;
        execute();
    }

    public void removeNameFilter() {
        this.nameFilter = "";
        execute();
    }

    public void removeTypeFilter() {
        this.nameFilter = "";
        execute();
    }

    private GetPokemonsUseCase getPokemonsUseCase() {
        return PokemonApplicationInjector.injectGetPokemonsUseCase();
    }
}
