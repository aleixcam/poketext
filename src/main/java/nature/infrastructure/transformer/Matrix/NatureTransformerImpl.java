package nature.infrastructure.transformer.Matrix;

import common.domain.MatrixService;
import nature.application.NatureTransformer;
import nature.domain.Nature;
import nature.domain.NaturesCollection;

import java.util.ArrayList;

final public class NatureTransformerImpl implements NatureTransformer {

    private final String[] COLUMNS = {"ID", "Name", "Modifiers"};

    private final MatrixService matrixService;

    public NatureTransformerImpl(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    public String[][] assemble(NaturesCollection collection) {
        ArrayList<Nature> natures = collection.getNatures();
        String[][] matrix = matrixService.generate(COLUMNS, natures.size());
        String[] stats = {"HP", "Atk", "Def", "SpA", "SpD", "Spe"};

        for (int i = 0; i < natures.size(); i++) {
            matrix[i+1][0] = String.valueOf(natures.get(i).getId());
            matrix[i+1][1] = natures.get(i).getName();
            matrix[i+1][2] = String.format("+%s, -%s",
                stats[natures.get(i).getIncreasedStat() - 1],
                stats[natures.get(i).getDecreasedStat() - 1]
            );
        }

        return matrixService.beautify(matrix);
    }
}
