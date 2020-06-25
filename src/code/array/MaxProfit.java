package code.array;

/**
 * 121. 买卖股票最佳时机
 */
public class MaxProfit {
    public int maxProfit1(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    ans = Math.max(prices[j] - prices[i], ans);
                }
            }
        }
        return ans;
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int minprice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minprice = Math.min(minprice, prices[i]);
            profit= Math.max(profit, prices[i] - minprice);
        }
        return profit;
    }
}
