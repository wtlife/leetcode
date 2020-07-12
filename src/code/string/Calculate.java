package code.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 227. 基本计算器
 */
public class Calculate {
    public int calculate(String s) {
        int lastNum = 0;
        int lastOperator = '+';
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0') {
                lastNum = lastNum * 10  + Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            if ((s.charAt(i) < '0' && s.charAt(i) != ' ') || i==s.length()-1) {
                if (lastOperator == '+') {
                    stack.addLast(lastNum);
                }
                if (lastOperator == '-') {
                    stack.addLast(-lastNum);
                }
                if (lastOperator == '*') {
                    Integer tmp = stack.pollLast() * lastNum;
                    stack.addLast(tmp);
                }
                if (lastOperator == '/') {
                    Integer tmp = stack.pollLast() / lastNum;
                    stack.addLast(tmp);
                }
                lastNum = 0;
                lastOperator = s.charAt(i);
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pollLast();
        }

        return res;
    }
}
