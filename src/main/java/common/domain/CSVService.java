package common.domain;

public interface CSVService {

    String[][] fromCSV(String[] data);
    String[] toCSV(String[][] matrix);
    String[][][] fromCSV3(String[] data);
    String[] toCSV3(String[][][] parallelepiped);
}
