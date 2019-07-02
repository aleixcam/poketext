package pokemon.infrastructure.controller;

import pokemon.application.GetPokemons.GetPokemonsUseCase;
import pokemon.infrastructure.injector.PokemonApplicationInjector;
import common.infrastructure.classes.cercador.Pokedex;
import common.infrastructure.printer.MatrixPrinter;

final public class PokemonController {

    private String nameFilter = "";
    private String typeFilter = "";
    private String[] pokedex;

    public void execute() {
        String[][] pokemons = getPokemonsUseCase().execute(Integer.parseInt(pokedex[0]), nameFilter, typeFilter);

        System.out.printf("%n%nPokèdex: %s%n", pokedex[1]);
        System.out.printf("Nom: %s Tipus: %s%n", nameFilter, typeFilter);
        MatrixPrinter.print(pokemons);
        System.out.printf("Nom: %s Tipus: %s%n", nameFilter, typeFilter);
        System.out.printf("Pokèdex: %s%n%n", pokedex[1]);
    }

    public void selectPokedex() {
        this.pokedex = Pokedex.cercarPokedex();
    }

    public void setNameFilter(String nameFilter) {
        this.nameFilter = nameFilter;
    }

    public void setTypeFilter(String typeFilter) {
        this.typeFilter = typeFilter;
    }

    public void removeNameFilter() {
        this.nameFilter = "";
    }

    public void removeTypeFilter() {
        this.nameFilter = "";
    }

    private GetPokemonsUseCase getPokemonsUseCase() {
        return PokemonApplicationInjector.injectGetPokemonsUseCase();
    }
}
