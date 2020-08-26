package code.sword;

/**
 * @Desc 41.MaxSubArray
 * @date 2020/8/26
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int res = nums[0];
        int tmp = 0;
        for (int num : nums) {
            if (tmp < 0) {
                tmp = num;
            } else {
                tmp += num;
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}
