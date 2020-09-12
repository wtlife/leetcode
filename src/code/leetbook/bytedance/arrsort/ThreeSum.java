package code.leetbook.bytedance.arrsort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Desc ThreeSum
 * @date 2020/9/12
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int j = 0; j < nums.length - 2; j++) {
            int cur = nums[j];
            if (cur > 0) {
                break;
            }
            //distinct
            if (j > 0 && nums[j] == nums[j - 1]) {
                continue;
            }

            int left = j + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[j] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[j], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }

                if (sum > 0) {
                    right--;
                }

                if (sum < 0) {
                    left++;
                }
            }
        }
        return res;
    }
}
