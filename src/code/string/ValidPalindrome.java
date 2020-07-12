package code.string;

/**
 * 680. 验证回文字符串
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isValid(s, i + 1, j) || isValid(s, i, j - 1);
            }
        }
        return true;
    }

    private boolean isValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}
