package code.leetbook.bytedance.str;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc LengthOfLongestSubstring
 * @date 2020/9/8
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int ans = 0;
        int left = 0, right = 0;
        Set<Character> visited = new HashSet<>();
        while (right < s.length()) {
            while (right < s.length() && visited.add(s.charAt(right))) {
                right++;
            }

            ans = Math.max(ans, right - left );

            while (right < s.length() && left < right && visited.contains(s.charAt(right))) {
                visited.remove(s.charAt(left));
                left++;
            }
        }
        return ans;
    }
}
