package code.daybyday;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins.length <= 0) {
            return -1;
        }
        int[] memo = new int[amount + 1];
        memo[0] = 0;

        for (int i = 1; i < amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (amount - coins[j] < 0) {
                    continue;
                }
                if (memo[i - coins[j]] < min) {
                    min = memo[i - coins[j]] + 1;
                }
            }
            memo[i] = min;
        }

        return memo[amount];
    }
}
