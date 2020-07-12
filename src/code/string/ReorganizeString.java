package code.string;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 767.重构字符串
 */
public class ReorganizeString {
    public String reorganizeString(String S) {
        PriorityQueue<letter> queue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        int[] countNums = new int[26];
        for (char c : S.toCharArray()) {
            countNums[c - 'a']++;
        }
        for (int i = 0; i < countNums.length; i++) {
            if (countNums[i] == 0) {
                continue;
            }
            letter l = new letter();
            l.a = (char) ('a' + i);
            l.count = countNums[i];
            queue.add(l);
        }
        if (queue.peek().count > (S.length() + 1) / 2) {
            return "";
        }
        char[] resChar = new char[S.length()];
        int i = 0;
        while (!queue.isEmpty()) {
            if (i >= S.length()) {
                i = 1;
            }
            letter tmp = queue.poll();
            while (tmp.count != 0) {
                if (i >= S.length()) {
                    i = 1;
                }
                resChar[i] = tmp.a;
                tmp.count--;
                i += 2;
            }
        }
        return new String(resChar);
    }


    private class letter {
        char a;
        int count;
    }
}
