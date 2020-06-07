package code.daybyday.june;

/**
 * 面试题29. 顺时针打印矩阵
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        //上下左右边界
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            //左->右
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if (++t > b) break;
            //上->下
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if (--r < l) break;
            //右->左
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i];
            }
            if (--b < t) break;
            //下->上
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if (++l > r) break;

        }
        return res;
    }
}
