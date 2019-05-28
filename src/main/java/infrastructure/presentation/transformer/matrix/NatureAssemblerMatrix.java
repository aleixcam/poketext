package infrastructure.presentation.transformer.matrix;

import application.nature.NatureAssembler;
import domain.nature.Nature;
import domain.nature.NaturesCollection;

import java.util.ArrayList;

public class NatureAssemblerMatrix extends MatrixAssembler implements NatureAssembler {

    public String[][] assemble(NaturesCollection collection) {
        ArrayList<Nature> natures = collection.getNatures();
        String[] columns = {"ID", "Name", "Modifiers"};
        String[][] matrix = new String[natures.size() + 1][columns.length];
        String[] stats = {"HP", "Atk", "Def", "SpA", "SpD", "Spe"};

        matrix[0] = columns;
        for (int i = 0; i < natures.size(); i++) {
            matrix[i+1][0] = String.valueOf(natures.get(i).getId());
            matrix[i+1][1] = natures.get(i).getName();
            matrix[i+1][2] = String.format("+%s, -%s",
                    stats[natures.get(i).getIncreasedStat() - 1],
                    stats[natures.get(i).getDecreasedStat() - 1]
            );
        }

        return generate(matrix);
    }
}
