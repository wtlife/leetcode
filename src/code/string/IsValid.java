package code.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 */
public class IsValid {
    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            Character cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.addLast(cur);
            } else {
                if (!stack.isEmpty() && isSame(cur, stack.peekLast())) {
                    stack.removeLast();
                } else {
                    stack.addLast(cur);
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isSame(Character cur, Character exist) {
        if (cur.equals(')') && exist.equals('(')) {
            return true;
        }
        if (cur.equals(']') && exist.equals('[')) {
            return true;
        }

        if (cur.equals('}') && exist.equals('{')) {
            return true;
        }
        return false;
    }
}
