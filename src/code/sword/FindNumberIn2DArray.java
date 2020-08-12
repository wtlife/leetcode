package code.sword;

/**
 * 04. 二维数组中的查找
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        if (matrix.length==0||matrix[0].length==0){
            return false;
        }
        int col = 0;
        int row = matrix[0].length - 1;
        while (col < matrix.length && row >= 0) {
            int temp = matrix[col][row];

            if (temp == target) {
                return true;
            } else if (temp > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;

    }
}
