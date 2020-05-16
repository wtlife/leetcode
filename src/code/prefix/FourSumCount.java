package code.prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加
 */
public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> sumAB = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                sumAB.put(sum, sumAB.getOrDefault(sum, 0) + 1);
            }
        }

        int ans = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = -(c + d);
                if (sumAB.containsKey(sum)) {
                    ans += sumAB.get(sum);
                }
            }
        }
        return ans;
    }
}
