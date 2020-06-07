package code.daybyday.june;


import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int res = 0;
        for (Integer num : numSet) {
            if (numSet.contains(num-1)){
                continue;
            }
            int streak = 1;
            int temp = num;
            while (numSet.contains(temp + 1)) {
                temp++;
                streak++;
            }
            res = Math.max(streak, res);
        }
        return res;
    }
}
