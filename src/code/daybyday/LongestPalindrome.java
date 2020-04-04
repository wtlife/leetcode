package code.daybyday;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int len = s.length();
        if (len < 1) {
            return 0;
        }
        int res = 0;
        int[] letters = new int[128];
        for (char a : s.toCharArray()) {
            letters[a] += 1;
        }
        for (int i : letters) {
            res += i / 2 * 2;
            if (i % 2 == 1 && res % 2 == 0) {
                res += 1;
            }
        }
        return res;
    }
}
