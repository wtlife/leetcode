package code.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (indexMap.containsKey(target - value)) {
                return new int[]{indexMap.get(target-value), i};
            }
            indexMap.put(value, i);
        }
        throw new IllegalArgumentException();
    }
}
