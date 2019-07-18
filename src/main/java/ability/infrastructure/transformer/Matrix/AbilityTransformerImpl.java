package ability.infrastructure.transformer.Matrix;

import ability.application.AbilityTransformer;
import ability.domain.AbilitiesCollection;
import ability.domain.Ability;
import common.infrastructure.service.MatrixService;

import java.util.ArrayList;

final public class AbilityTransformerImpl implements AbilityTransformer {

    private final String[] COLUMNS = {"ID", "Name", "Effect"};

    private final MatrixService matrixService;

    public AbilityTransformerImpl(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    public String[][] assemble(AbilitiesCollection collection) {
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
