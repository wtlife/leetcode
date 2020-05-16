package code.prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {
                if ((nums[i] + nums[j]) == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return ans;
    }


    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (indexMap.containsKey(comp)) {
                return new int[]{indexMap.get(comp), i};
            }
            indexMap.put(nums[i], i);
        }

        return null;
    }

}
