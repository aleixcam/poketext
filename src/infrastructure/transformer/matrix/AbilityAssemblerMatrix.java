package infrastructure.transformer.matrix;

import application.ability.AbilityAssembler;
import domain.ability.AbilitiesCollection;
import domain.ability.Ability;

import java.util.ArrayList;

public class AbilityAssemblerMatrix extends MatrixAssembler implements AbilityAssembler {

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
