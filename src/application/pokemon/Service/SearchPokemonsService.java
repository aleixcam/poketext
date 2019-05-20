package application.pokemon.Service;

import application.pokemon.GetPokemons.GetPokemonsUseCase;
import infrastructure.persistence.SQLite.PokemonRepositorySQLite;
import infrastructure.poketext.cercador.Pokedex;
import infrastructure.presentation.printer.MatrixPrinter;
import infrastructure.presentation.transformer.matrix.PokemonAssemblerMatrix;

public class SearchPokemonsService {

    private String nameFilter = "";
    private String typeFilter = "";
    private String[] pokedex;

    public void execute() {
        GetPokemonsUseCase service = new GetPokemonsUseCase(new PokemonRepositorySQLite(), new PokemonAssemblerMatrix());
        String[][] pokemons = service.execute(Integer.parseInt(pokedex[0]), nameFilter, typeFilter);

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
}
