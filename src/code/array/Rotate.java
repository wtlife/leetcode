package code.array;

/**
 * 48. 旋转图像
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int m = matrix.length;

        //上下
        for (int i = 0; i < m / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[m - i - 1];
            matrix[m - i - 1] = temp;
        }

        //按对角线对折
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

}
