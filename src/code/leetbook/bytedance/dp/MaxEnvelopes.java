package code.leetbook.bytedance.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Desc MaxEnvelopes
 * @date 2020/9/24
 */
public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes==null || envelopes.length<1){
            return 0;
        }
        Arrays.sort(envelopes,(v1,v2)->{
            if (v1[0]!=v2[0]){
                return v1[0] - v2[0];
            }else {
                return v2[1]-v1[1];
            }
        });

        int[] dp= new int[envelopes.length];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i = 0; i <envelopes.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if (envelopes[i][0] >envelopes[j][0] && envelopes[i][1]>envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
