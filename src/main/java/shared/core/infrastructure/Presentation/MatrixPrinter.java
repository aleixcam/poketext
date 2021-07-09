package shared.core.infrastructure.Presentation;

final public class MatrixPrinter {

    public static void print(String[][] matrix) {
        String[] format = new String[matrix[0].length];
        format[0] = "%" + (maxLength(matrix, 0) - 2) + "s";
        for (int i = 1; i < format.length; i++) {
            format[i] = "%-" + maxLength(matrix, i) + "s";
        }
        System.out.printf(format[0], matrix[0][0]);
        for (int i = 1; i < matrix[0].length; i++) {
            System.out.printf(format[i], " | " + matrix[0][i]);
        }
        System.out.println();
        for (int i = 0; i < 96; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 1; i < matrix.length; i++) {
            System.out.print(String.format(format[0], matrix[i][0]));
            for (int j = 1; j < matrix[i].length; j++) {
                System.out.printf(format[j], " | " + matrix[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < 96; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf(format[0], matrix[0][0]);
        for (int i = 1; i < matrix[0].length; i++) {
            System.out.printf(format[i], " | " + matrix[0][i]);
        }
        System.out.println();
    }

    private static int maxLength(String[][] matrix, int pos) {
        int res = 1;
        for (String[] row : matrix) {
            if (row[pos].length() > res) {
                res = row[pos].length();
            }
        }

        return res + 3;
    }
}
