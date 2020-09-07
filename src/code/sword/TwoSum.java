package code.sword;

/**
 * @Desc 57.TwoSum
 * @date 2020/9/4
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {
            return null;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
