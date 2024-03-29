package indexer.ability.infrastructure.transformer.Matrix;

import indexer.ability.application.AbilityTransformer;
import indexer.ability.domain.AbilityCollection;
import shared.ability.domain.Ability;
import shared.core.infrastructure.Service.MatrixService;

import java.util.ArrayList;

final public class MatrixAbilityTransformer implements AbilityTransformer<String[][]> {

    private final String[] COLUMNS = {"ID", "Name", "Effect"};

    private final MatrixService matrixService;

    public MatrixAbilityTransformer(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    public String[][] transform(AbilityCollection collection) {
        ArrayList<Ability> abilities = collection.getItems();
        String[][] matrix = matrixService.generate(COLUMNS, abilities.size());

        for (int i = 0; i < abilities.size(); i++) {
            matrix[i+1][0] = String.valueOf(abilities.get(i).id());
            matrix[i+1][1] = abilities.get(i).name();
            matrix[i+1][2] = abilities.get(i).effect();
        }

        return matrixService.beautify(matrix);
    }
}
