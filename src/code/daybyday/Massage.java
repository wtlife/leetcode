package code.daybyday;

public class Massage {
    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int res;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[0] = nums[0];
                continue;
            }
            if (i == 1) {
                dp[1] = Math.max(dp[0], nums[1]);
                continue;
            }

            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}
