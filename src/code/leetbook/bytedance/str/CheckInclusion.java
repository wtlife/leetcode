package code.leetbook.bytedance.str;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Desc CheckInclusion
 * @date 2020/9/8
 */
public class CheckInclusion {
    List<String> list = new ArrayList<>();

    public boolean checkInclusion(String s1, String s2) {
        helper(s1, "", new HashSet<>());
        for (String str : list) {
            if (s2.contains(str)) {
                return true;
            }
        }
        return false;
    }

    private void helper(String s1, String s, HashSet<Integer> set) {
        if (s.length() == s1.length()) {
            list.add(s);
            return;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (set.contains(i)) {
                continue;
            }
            set.add(i);
            helper(s1, s + s1.charAt(i), set);
            set.remove(i);
        }
    }

    public boolean checkInclusion2(String s1, String s2) {
        if (s1 == null || s1.length() < 1) {
            return true;
        }

        int wid = s1.length();
        int[] s1Arr = new int[26];
        for (char c : s1.toCharArray()) {
            s1Arr[c - 'a']++;
        }

        int right = 0;
        int[] s2Arr = new int[26];
        while (right < s2.length()) {
            s2Arr[s2.charAt(right) - 'a']++;
            right++;

            int left = right - wid ;
            if (left >= 0) {
                if (match(s1Arr, s2Arr)) {
                    return true;
                }
                s2Arr[s2.charAt(left) - 'a']--;
            }
        }

        return false;
    }

    private boolean match(int[] s1Arr, int[] s2Arr) {
        for (int i = 0; i < 26; i++) {
            if (s1Arr[i] > 0 && s1Arr[i] != s2Arr[i]) {
                return false;
            }
        }
        return true;
    }

}

