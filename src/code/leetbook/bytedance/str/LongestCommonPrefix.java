package code.leetbook.bytedance.str;

/**
 * @Desc LongestCommonPrefix
 * @date 2020/9/8
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        String first = strs[0];
        int idx = 0;
        for (; idx < minLen; idx++) {
            char cur = first.charAt(idx);
            if (!checkSame(strs, cur, idx)) {
                break;
            }
        }
        return first.substring(0,idx);
    }

    private boolean checkSame(String[] strs, char c, int idx) {
        for (String str : strs) {
            if (!(str.charAt(idx) == c)) {
                return false;
            }
        }
        return true;
    }


}
