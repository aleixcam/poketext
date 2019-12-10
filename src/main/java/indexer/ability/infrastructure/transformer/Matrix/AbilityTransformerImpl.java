package indexer.ability.infrastructure.transformer.Matrix;

import indexer.ability.application.AbilityTransformer;
import indexer.ability.domain.AbilityCollection;
import indexer.ability.domain.Ability;
import shared.domain.MatrixService;

import java.util.ArrayList;

final public class AbilityTransformerImpl implements AbilityTransformer<String[][]> {

    private final String[] COLUMNS = {"ID", "Name", "Effect"};

    private final MatrixService matrixService;

    public AbilityTransformerImpl(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    public String[][] transform(AbilityCollection collection) {
        ArrayList<Ability> abilities = collection.getItems();
        String[][] matrix = matrixService.generate(COLUMNS, abilities.size());

        for (int i = 0; i < abilities.size(); i++) {
            matrix[i+1][0] = String.valueOf(abilities.get(i).getId());
            matrix[i+1][1] = abilities.get(i).getName();
            matrix[i+1][2] = abilities.get(i).getEffect();
        }

        return matrixService.beautify(matrix);
    }
}
