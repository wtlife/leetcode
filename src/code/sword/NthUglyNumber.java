package code.sword;

/**
 * @Desc 49.NthUglyNumber
 * @date 2020/9/1
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        int n2 = 1, n3 = 1, n5 = 1;
        for (int i = 1; i < n; i++) {
            n2 = dp[a] * 2;
            n3 = dp[b] * 3;
            n5 = dp[c] * 5;

            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }

        return dp[n];
    }

}
