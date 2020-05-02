package code.daybyday.may;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int size = s.length();
        int ans = 0, right =-1;
        for (int left = 0; left < size; left++) {

            if (left != 0) {
                set.remove(s.charAt(left-1));
            }


            while (right+1 < size && !set.contains(s.charAt(right+1))) {
                set.add(s.charAt(right+1));
                right++;
            }
            ans = Math.max(ans, right - left - 1);

        }
        return ans;
    }
}
