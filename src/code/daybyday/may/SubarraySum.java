package code.daybyday.may;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 */
public class SubarraySum {

    //暴力法
    public int subarraySum(int[] nums, int k) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }


    //前缀和
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 1; i < len + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (preSum[j + 1] - preSum[i] == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    //前缀和优化
    public int subarraySum3(int[] nums, int k) {

        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        int ans = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            if (preSumMap.containsKey(preSum - k)) {
                ans += preSumMap.get(preSum - k);
            }
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }


}
