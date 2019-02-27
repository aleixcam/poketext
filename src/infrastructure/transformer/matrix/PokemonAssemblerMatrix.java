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
            matrix[i+1][4] = String.valueOf(items.get(i).getBaseStats().getHealth());
            matrix[i+1][5] = String.valueOf(items.get(i).getBaseStats().getAttack());
            matrix[i+1][6] = String.valueOf(items.get(i).getBaseStats().getDefense());
            matrix[i+1][7] = String.valueOf(items.get(i).getBaseStats().getSpecialAttack());
            matrix[i+1][8] = String.valueOf(items.get(i).getBaseStats().getSpecialDefense());
            matrix[i+1][9] = String.valueOf(items.get(i).getBaseStats().getSpeed());
        }

        return generate(matrix);
    }
}
