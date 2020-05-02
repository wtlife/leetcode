package code.daybyday.marchapril;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int res = 0;
        int minPrice = prices[0];
        for (int i = 0; i < len; i++) {
            minPrice = Math.min(minPrice,prices[i]);
            res = Math.max(res,prices[i]-minPrice);
        }
        return res;
    }
}
