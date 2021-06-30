package shared.core.domain.Service;

public interface CSVService {

    String[] toCSV(String[][] matrix);
    String[] toCSV(String[][][] parallelepiped);
    String[][] toMatrix(String[] data);
    String[][][] toParallelepiped(String[] data);
}
