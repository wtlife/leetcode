package code.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc 48.LengthOfLongestSubstring
 * @date 2020/9/1
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, left = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            Character cur = s.charAt(right);
            if (map.containsKey(cur)) {
                left =Math.max(map.get(cur),left) ;
            }
            map.put(cur, right);
            res = Math.max(res, right - left);
        }
        return res;
    }
}




