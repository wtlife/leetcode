package code.daybyday.may;

import com.sun.source.doctree.InheritDocTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 */
public class MinWindow {
    Map<Character, Integer> tCntMap = new HashMap<>();
    Map<Character, Integer> sCntMap = new HashMap<>();

    public String minWindow(String s, String t) {

        Map<Character, Integer> tCntMap = new HashMap<>();
        char[] tchars = t.toCharArray();
        for (char c : tchars) {
            tCntMap.put(c, tCntMap.getOrDefault(c, 0) + 1);
        }
        this.tCntMap = tCntMap;

        int left = 0;
        int right = -1;

        int minLen = Integer.MAX_VALUE;
        int ansLeft = -1;
        while (right < s.length()) {

            //向右移动右指针
            right++;
            if (right < s.length()) {
                char cur = s.charAt(right);
                if (tCntMap.containsKey(cur)) {
                    sCntMap.put(cur, sCntMap.getOrDefault(cur, 0) + 1);
                }
            }

            //若包含所有子串，移动左指针
            while (check() && left <= right) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ansLeft = left;
                }

                char leftCur = s.charAt(left);
                if (tCntMap.containsKey(leftCur)) {
                    sCntMap.put(leftCur, sCntMap.getOrDefault(leftCur, 0) - 1);
                }
                left++;
            }

        }
        return ansLeft == -1 ? "" : s.substring(ansLeft, ansLeft + minLen);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> tEntry : tCntMap.entrySet()) {
            Character key = tEntry.getKey();
            Integer val = tEntry.getValue();
            if (sCntMap.get(key) == null || sCntMap.get(key) < val) {
                return false;
            }
        }
        return true;
    }

}
