package code.string;

/**
 * 5. 最长回文子串
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String str1 = expand(s, i, i);
            String str2 = expand(s, i, i + 1);
            String str = str1.length() > str2.length() ? str1 : str2;

            if (str.length() > res.length()) {
                res = str;
            }

        }
        return res;
    }

    private String expand(String s, int left, int right) {
        int i = left;
        int j = right;

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
