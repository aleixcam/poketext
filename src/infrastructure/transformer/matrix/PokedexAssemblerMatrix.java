package infrastructure.transformer.matrix;

import domain.pokedex.Pokedex;
import application.pokedex.PokedexAssembler;
import domain.pokedex.PokedexesCollection;

import java.util.ArrayList;

public class PokedexAssemblerMatrix extends MatrixAssembler implements PokedexAssembler {

    public String[][] assemble(PokedexesCollection collection) {
        ArrayList<Pokedex> pokedexes = collection.getPokedexes();
        String[] columns = {"ID", "Name", "Description"};
        String[][] matrix = new String[pokedexes.size() + 1][columns.length];

        matrix[0] = columns;
        for (int i = 0; i < pokedexes.size(); i++) {
            matrix[i+1][0] = String.valueOf(pokedexes.get(i).getId());
            matrix[i+1][1] = pokedexes.get(i).getName();
            matrix[i+1][2] = pokedexes.get(i).getDescription();
        }

        return generate(matrix);
    }
}
