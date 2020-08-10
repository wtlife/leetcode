package code.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 150.EvalRPN
 * @date 2020/8/9
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                if (s.equals("+")) stack.push(left + right);
                if (s.equals("-")) stack.push(left - right);
                if (s.equals("*")) stack.push(left * right);
                if (s.equals("/")) stack.push(left / right);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
