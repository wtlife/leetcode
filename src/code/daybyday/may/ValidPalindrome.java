package code.daybyday.may;

/**
 * 680. 验证回文字符串 Ⅱ
 */
public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return true;
        }
        int left = 0;
        int right = len - 1;
        int chance = 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar != rightChar) {
                return isValid(left + 1, right, s) || isValid(left, right - 1, s);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isValid(int left, int right, String s) {
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
