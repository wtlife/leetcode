package code.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1249. 移除无效的括号
 */
public class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> remove = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.addLast(i);
            }
            if (cur == ')') {
                if (stack.isEmpty()) {
                    remove.add(i);
                } else {
                    stack.removeLast();
                }
            }
        }
        while (!stack.isEmpty()) {
            remove.add(stack.removeLast());
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (remove.contains(i)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}


