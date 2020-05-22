package code.daybyday.may;

/**
 * 5. 最长回文串
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        String ans = "";
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((j - i + 1) < maxLen) {
                    continue;
                }

                if (!isValidPalindrome(charArray, i, j)) {
                    continue;
                }

                maxLen = j - i + 1;
                begin = i;
            }
        }
        ans = s.substring(begin, begin + maxLen);
        return ans;
    }

    private boolean isValidPalindrome(char[] charArray, int i, int j) {
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }


        int maxlen = 1;
        int begin = 0;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if ((j - 1) - (i + 1) + 1 < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if ((j - i + 1) > maxlen && dp[i][j]) {
                    begin = i;
                    maxlen = j - i + 1;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
}
