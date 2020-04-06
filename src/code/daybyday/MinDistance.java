package code.daybyday;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 * len2 == 0) {
            return len1 + len2;
        }

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < len2 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                int left = dp[i - 1][j] + 1;
                int right = dp[i][j - 1] + 1;
                int same = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    same += 1;
                }

                dp[i][j] = Math.min(Math.min(left, right), same);
            }
        }

        return dp[len1][len2];
    }
}
