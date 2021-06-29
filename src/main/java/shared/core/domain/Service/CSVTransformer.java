package shared.core.domain.Service;

public interface CSVTransformer<T> {

    String[][] toCSV(T data);
    String[][][] toCSV3(T data);
    T fromCSV(String[][] matrix);
    T fromCSV3(String[][][] parallelepiped);
}
