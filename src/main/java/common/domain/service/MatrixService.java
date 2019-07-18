package common.domain.service;

public interface MatrixService {

    String[][] generate(String[] columns, int rows);
    String[][] beautify(String[][] matrix);
}
