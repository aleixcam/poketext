package infrastructure.transformer.matrix;

import domain.pokemon.Pokemon;
import domain.pokemon.PokemonAssembler;
import domain.pokemon.PokemonsCollection;

import java.util.ArrayList;

public class PokemonAssemblerMatrix extends MatrixAssembler implements PokemonAssembler {

    public String[][] assemble(PokemonsCollection pokemons) {
        ArrayList<Pokemon> items = pokemons.pokemons();
        String[] columns = {"ID", "Name", "Type 1", "Type 2", "HP", "Atk", "Def", "SpA", "SpD", "Spe"};
        String[][] matrix = new String[items.size() + 1][columns.length];

        matrix[0] = columns;
        for (int i = 0; i < items.size(); i++) {
            matrix[i+1][0] = String.valueOf(items.get(i).getId());
            matrix[i+1][1] = items.get(i).getName();
            matrix[i+1][2] = items.get(i).getTypeOne();
            matrix[i+1][3] = items.get(i).getTypeTwo();
            matrix[i+1][4] = null;
            matrix[i+1][5] = null;
            matrix[i+1][6] = null;
            matrix[i+1][7] = null;
            matrix[i+1][8] = null;
            matrix[i+1][9] = null;
        }

        return matrix;
    }
}
