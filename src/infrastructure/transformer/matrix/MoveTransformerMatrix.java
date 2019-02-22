package infrastructure.transformer.matrix;

import domain.move.MoveAssembler;
import domain.move.MovesCollection;

public class MoveTransformerMatrix extends MatrixTransformer implements MoveAssembler {

    public String[][] assemble(MovesCollection moves) {
        return new String[0][];
    }
}
