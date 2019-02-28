package infrastructure.transformer.matrix;

import domain.pokemon.Pokemon;
import domain.pokemon.PokemonAssembler;
import domain.pokemon.PokemonsCollection;

import java.util.ArrayList;

public class PokemonAssemblerMatrix extends MatrixAssembler implements PokemonAssembler {

    public String[][] assemble(PokemonsCollection collection) {
        ArrayList<Pokemon> pokemons = collection.getPokemons();
        String[] columns = {"ID", "Name", "Type 1", "Type 2", "HP", "Atk", "Def", "SpA", "SpD", "Spe"};
        String[][] matrix = new String[pokemons.size() + 1][columns.length];

        matrix[0] = columns;
        for (int i = 0; i < pokemons.size(); i++) {
            matrix[i+1][0] = String.valueOf(pokemons.get(i).getId());
            matrix[i+1][1] = pokemons.get(i).getName();
            matrix[i+1][2] = pokemons.get(i).getTypeOne();
            matrix[i+1][3] = pokemons.get(i).getTypeTwo();
            matrix[i+1][4] = String.valueOf(pokemons.get(i).getBaseStats().getHealth());
            matrix[i+1][5] = String.valueOf(pokemons.get(i).getBaseStats().getAttack());
            matrix[i+1][6] = String.valueOf(pokemons.get(i).getBaseStats().getDefense());
            matrix[i+1][7] = String.valueOf(pokemons.get(i).getBaseStats().getSpecialAttack());
            matrix[i+1][8] = String.valueOf(pokemons.get(i).getBaseStats().getSpecialDefense());
            matrix[i+1][9] = String.valueOf(pokemons.get(i).getBaseStats().getSpeed());
        }

        return generate(matrix);
    }
}
