package code.array;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int leftEle = nums[left];
                int rightEle = nums[right];
                int sum = leftEle + rightEle + ele;

                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }

                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return target;
                }
            }

        }

        return ans;
    }
}
