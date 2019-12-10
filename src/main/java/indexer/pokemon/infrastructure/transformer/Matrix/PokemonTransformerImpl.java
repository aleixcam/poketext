package indexer.pokemon.infrastructure.transformer.Matrix;

import shared.domain.MatrixService;
import indexer.pokemon.domain.Pokemon;
import indexer.pokemon.application.PokemonTransformer;
import indexer.pokemon.domain.PokemonCollection;

import java.util.ArrayList;

final public class PokemonTransformerImpl implements PokemonTransformer<String[][]> {

    private final String[] COLUMNS = {"ID", "Name", "Type 1", "Type 2", "HP", "Atk", "Def", "SpA", "SpD", "Spe"};

    private final MatrixService matrixService;

    public PokemonTransformerImpl(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    public String[][] transform(PokemonCollection collection) {
        ArrayList<Pokemon> pokemons = collection.getPokemons();
        String[][] matrix = matrixService.generate(COLUMNS, pokemons.size());

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

        return matrixService.beautify(matrix);
    }
}
