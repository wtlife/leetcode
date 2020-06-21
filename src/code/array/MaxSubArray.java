package code.array;

/**
 * 53. 最大子序列和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int temp = 0;
        int res = nums[0];
        for (int num : nums) {
            if (temp > 0) {
                temp += num;
            } else {
                temp = num;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
