package code.dp;


/**
 *
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int dp[] = new int[len];
        int res = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}
