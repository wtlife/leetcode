package code.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 */
public class MinWindow {
    public String minWindow(String s, String t) {

        int left = 0, right = 0;
        int len = Integer.MAX_VALUE;
        String res = "";

        Map<Character, Integer> tCntMap = new HashMap<>();
        Map<Character, Integer> sCntMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCntMap.put(c, tCntMap.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {

            while (right < s.length() && !isContain(sCntMap,tCntMap)) {
                sCntMap.put(s.charAt(right), sCntMap.getOrDefault(s.charAt(right), 0) + 1);
                right++;
            }

            while (left< right && isContain(sCntMap,tCntMap)) {
                int tmpLen = right - left + 1;
                if (tmpLen < len) {
                    len = tmpLen;
                    res = s.substring(left, right );
                }
                sCntMap.put(s.charAt(left), sCntMap.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
        }

        return res;
    }

    private boolean isContain(Map<Character, Integer> sCntMap, Map<Character, Integer> tCntMap) {
        for (Character key : tCntMap.keySet()) {
            Integer value = sCntMap.get(key);
            if (value==null|| value<tCntMap.get(key)){
                return false;
            }
        }
        return true;
    }

}
