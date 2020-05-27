package code.daybyday.may;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 */
public class SubarraysDivByK {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        cntMap.put(0, 1);
        int ans = 0;
        int sum = 0;
        for (int a : A) {
            sum += a;
            int mod = (sum % K + K) % K;
            int cnt = cntMap.getOrDefault(mod, 0);

            ans += cnt;
            cntMap.put(mod, cnt + 1);
        }
        return ans;
    }
}
