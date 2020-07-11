package code.string;

import javax.swing.text.AttributeSet;
import java.lang.reflect.Parameter;

/**
 * 91. 解码方法
 */
public class NumDecodings {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            String cur = String.valueOf(s.charAt(i));
            String pre = String.valueOf(s.charAt(i - 1));
            if (cur.equals("0")) {
                if (pre.equals("1") || pre.equals("2")) {
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;
                }
                continue;
            }
            if (pre.equals("1")) {
                dp[i + 1] = dp[i] + dp[i - 1];
                continue;
            }
            int curInt = Integer.parseInt(cur);
            if (pre.equals("2") && curInt <= 6 && curInt >= 1) {
                dp[i + 1] = dp[i] + dp[i - 1];
                continue;
            }

            dp[i + 1] = dp[i];
        }
        return dp[s.length()];

    }
}
