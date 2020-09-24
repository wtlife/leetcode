package code.leetbook.bytedance.dp;

/**
 * @Desc MaxProfit
 * @date 2020/9/24
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int ans = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int cur = prices[i];
            ans = Math.max(ans, cur - minPrice);
            minPrice = Math.min(minPrice, cur);
        }
        return ans;

    }
}
