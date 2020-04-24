package code.daybyday;

import java.util.Arrays;

/**
 * 面试题 08.11. 硬币
 */
public class WaysToChange {
    public int waysToChange(int n) {
        int[] change = new int[]{1, 5, 10, 25};
        int[][] dp = new int[4][n + 1];
        for (int i = 0; i < 4; i++) {
            dp[i][1] = 1;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < 4; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= change[i]) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - change[i]]) % 1000000007;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[3][n];
    }

    public int waysToChange2(int n) {
        int[] change = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= change[i]) {
                    dp[j] = (dp[j] + dp[j - change[i]]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
}
