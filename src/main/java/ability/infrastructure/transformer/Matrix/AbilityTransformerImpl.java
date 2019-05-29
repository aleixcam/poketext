package ability.infrastructure.transformer.Matrix;

import ability.application.AbilityTransformer;
import ability.domain.AbilitiesCollection;
import ability.domain.Ability;
import common.infrastructure.transformer.MatrixTransformer;

import java.util.ArrayList;

final public class AbilityTransformerImpl extends MatrixTransformer implements AbilityTransformer {

    public String[][] assemble(AbilitiesCollection collection) {
        ArrayList<Ability> abilities = collection.getItems();
        String[] columns = {"ID", "Name", "Effect"};
        String[][] matrix = new String[abilities.size() + 1][columns.length];

        matrix[0] = columns;
        for (int i = 0; i < abilities.size(); i++) {
            matrix[i+1][0] = String.valueOf(abilities.get(i).getId());
            matrix[i+1][1] = abilities.get(i).getName();
            matrix[i+1][2] = abilities.get(i).getEffect();
        }

        return generate(matrix);
    }
}
