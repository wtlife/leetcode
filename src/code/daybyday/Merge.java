package code.daybyday;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        int[][] res = new int[intervals.length][2];
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > res[index][1]) {
                res[++index] = interval;
            } else {
                res[index][1] = Math.max(res[index][1],interval[1]);
            }
        }
        return Arrays.copyOf(res,index+1);
    }
}
