package code.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 316. RemoveDuplicateLetters
 * @date 2020/8/7
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return s;
        }

        // 记录是否在已经得到的字符串中
        boolean[] set = new boolean[26];

        // 记录每个字符出现的最后一个位置
        int[] maxIdx = new int[26];
        for (int i = 0; i < len; i++) {
            maxIdx[s.charAt(i) - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (set[cur - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && stack.peekLast() > cur && maxIdx[stack.peekLast() - 'a'] >= i) {
                char top = stack.pollLast();
                set[top - 'a'] = false;
            }

            stack.addLast(cur);
            set[cur- 'a'] = true;
        }

        String res = "";
        while (!stack.isEmpty()){
            res = stack.pollLast() + res;
        }
        return res;
    }
}
