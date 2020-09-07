package code.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 57-2.FindContinuousSequence
 * @date 2020/9/4
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int end = (target >> 1) + 1;
        List<int[]> list = new ArrayList<>();
        for (int left = 1; left < end; left++) {
            int right = left + 1;
            while (right <= end) {
                int sum = getSum(left, right);
                if (sum == target) {
                    list.add(getArr(left, right));
                }
                if (sum > target) {
                    break;
                }
                right++;
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i <res.length ; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int[] getArr(int left, int right) {
        int[] res = new int[right - left + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = left + i;
        }
        return res;
    }

    private int getSum(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += i;
        }
        return sum;
    }
}
