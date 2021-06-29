package indexer.pokedex.infrastructure.transformer.Matrix;

import indexer.pokedex.domain.Pokedex;
import indexer.pokedex.application.PokedexTransformer;
import indexer.pokedex.domain.PokedexCollection;
import shared.core.infrastructure.Service.MatrixService;

import java.util.ArrayList;

final public class MatrixPokedexTransformer implements PokedexTransformer<String[][]> {

    private final String[] COLUMNS = {"ID", "Name", "Description"};

    private final MatrixService matrixService;

    public MatrixPokedexTransformer(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    public String[][] transform(PokedexCollection collection) {
        ArrayList<Pokedex> pokedexes = collection.getPokedexes();
        String[][] matrix = matrixService.generate(COLUMNS, pokedexes.size());

        for (int i = 0; i < pokedexes.size(); i++) {
            matrix[i+1][0] = String.valueOf(pokedexes.get(i).id());
            matrix[i+1][1] = pokedexes.get(i).name();
            matrix[i+1][2] = pokedexes.get(i).description();
        }

        return matrixService.beautify(matrix);
    }
}
