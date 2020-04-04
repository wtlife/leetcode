package code.daybyday;

import java.util.ArrayList;
import java.util.List;

public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        int j = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        while (i <= target / 2) {

            if (sum < target) {
                sum += j;
                j++;
            }

            if (sum > target) {
                sum -= i;
                i++;
            }

            if (sum == target) {
                int[] temp = new int[j - i];
                for (int k = i; k < j; k++) {
                    temp[k - i] = k;
                }
                res.add(temp);
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
