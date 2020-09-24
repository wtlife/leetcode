package code.leetbook.bytedance.dp;

/**
 * @Desc MaximalSquare
 * @date 2020/9/24
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int col = matrix.length, row = matrix[0].length;
        int[][] dp = new int[col][row];
        int maxSide = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                maxSide = Math.max(dp[i][j], maxSide);
            }
        }
        return maxSide * maxSide;
    }
}
