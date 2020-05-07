package code.daybyday.may;

/**
 * 983. 最低票价
 */
public class MincostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int length = days.length;
        //dp 表示在当前天数需要花的最少的钱
        int[] dp = new int[days[length - 1] + 1];

        int day_index = 0;
        for (int i = 1; i < dp.length; i++) {

            if (i == days[day_index]) {
                dp[i] = min(
                        dp[Math.max(i - 1, 0)] + costs[0],
                        dp[Math.max(i - 7, 0)] + costs[1],
                        dp[Math.max(i - 30, 0)] + costs[2]
                );
                day_index++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
