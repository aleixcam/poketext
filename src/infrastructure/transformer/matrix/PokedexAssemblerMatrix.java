package infrastructure.transformer.matrix;

import domain.pokedex.Pokedex;
import domain.pokedex.PokedexAssembler;
import domain.pokedex.PokedexesCollection;

import java.util.ArrayList;

public class PokedexAssemblerMatrix extends MatrixAssembler implements PokedexAssembler {

    public String[][] assemble(PokedexesCollection pokedexes) {
        ArrayList<Pokedex> items = pokedexes.pokedexes();
        String[] columns = {"ID", "Name", "Description"};
        String[][] matrix = new String[items.size() + 1][columns.length];

        matrix[0] = columns;
        for (int i = 0; i < items.size(); i++) {
            matrix[i+1][0] = String.valueOf(items.get(i).getId());
            matrix[i+1][1] = items.get(i).getName();
            matrix[i+1][2] = items.get(i).getDescription();
        }

        return generate(matrix);
    }
}
