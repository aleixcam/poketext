package common.domain;

public interface MatrixService {

    String[][] generate(String[] columns, int rows);
    String[][] beautify(String[][] matrix);
}
