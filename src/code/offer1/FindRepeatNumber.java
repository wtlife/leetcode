package code.offer1;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题03. 数组中重复的数字
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            boolean ss = set.add(num);
            if (!ss) {
                return num;
            }
        }
        return -1;
    }
}
