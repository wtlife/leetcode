package code.daybyday;

public class Rotate {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int mid = len >> 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < mid; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }
    }
}
