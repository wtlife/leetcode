package code.leetbook.bytedance.arrsort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Desc Merge
 * @date 2020/9/15
 */
public class Merge {
    public int[][] merge(int[][] intervals) {

        int[][] res = new int[intervals.length][2];
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                if (interval[1] > res[idx][1]) {
                    res[idx][1] = interval[1];
                }
            }
        }
        return Arrays.copyOf(res, idx+1);

    }
}
