package common.infrastructure.transformer;

public class MatrixTransformer {

    protected String[][] generate(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] != null ? matrix[i][j].replace("\n", " ") : "---";
            }
        }

        return matrix;
    }
}
