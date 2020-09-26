package code.leetbook.bytedance.dp;

import java.util.List;

/**
 * @Desc MinimumTotal
 * @date 2020/9/24
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int col = triangle.size();
        int row = triangle.get(col-1).size();

        int[][] dp = new int[col][row];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            List<Integer> curCol= triangle.get(i);
            for (int j = 0; j < curCol.size(); j++) {
                int value = curCol.get(j);
                if (i == 0) {
                    dp[i][j] = curCol.get(j);
                } else {
                    if (j - 1 < 0  ) {
                        dp[i][j] = dp[i - 1][j] + value;
                    } else if (j>=triangle.get(i-1).size()){
                        dp[i][j] = dp[i - 1][j-1] + value;
                    }else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + value;
                    }
                }
                if (i==col-1){
                    ans = Math.min(ans,dp[i][j]);
                }
            }
        }

        return ans;
    }
}
