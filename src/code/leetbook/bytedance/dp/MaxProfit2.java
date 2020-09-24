package code.leetbook.bytedance.dp;

/**
 * @Desc MaxProfit2
 * @date 2020/9/24
 */
public class MaxProfit2 {
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i];

            dp[i][0] = Math.max(cur + dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i-1][0]-cur,dp[i-1][1]);
        }

        int ans = dp[prices.length-1][0];
        return ans;
    }
}
