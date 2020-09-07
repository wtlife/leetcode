package code.sword;

/**
 * @Desc 60. TwoSum60
 * @date 2020/9/4
 */
public class TwoSum60 {


    public double[] twoSum(int n) {
        //dp[骰子个数][所有可能的值]
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        //i代表当前骰子的个数
        //j代表当前值的和
        //k代表当前筛子的值
        //状态转移方程： i个骰子和为j += i-1个骰子和为j-k + 第i个骰子值为k
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6 && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        //总次数
        double totalNum = Math.pow(6, n);
        double[] ans = new double[5 * n + 1];
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / totalNum;
        }
        return ans;
    }


}
