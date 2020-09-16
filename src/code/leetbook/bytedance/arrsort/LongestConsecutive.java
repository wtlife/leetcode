package code.leetbook.bytedance.arrsort;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc LongestConsecutive
 * @date 2020/9/15
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {

                int cur = num;
                int streak = 0;
                while (set.contains(cur)) {
                    cur++;
                    streak++;
                }
                res = Math.max(res, streak);
            }
        }
        return res;
    }
}
