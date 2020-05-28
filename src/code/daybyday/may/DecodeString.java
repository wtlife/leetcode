package code.daybyday.may;

import java.util.Stack;

/**
 * 394.字符串解码
 * s = "3[a2[c]]", 返回 "accaccacc".
 */
public class DecodeString {
    public String decodeString(String s) {
        char[] characters = s.toCharArray();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num = 0;

        for (char c : characters) {
            if (c == '[') {
                strStack.push(res.toString());
                res = new StringBuilder();
                numStack.push(num);
                num = 0;

            } else if (Character.isDigit(c)) {
                int tmp = Integer.parseInt(String.valueOf(c));
                num = num * 10 + tmp;

            } else if (c == ']') {
                Integer count = numStack.pop();
                String temp = res.toString();
                for (int i = 0; i < count - 1; i++) {
                    res.append(temp);
                }
                res = new StringBuilder(strStack.pop()).append(res);

            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}
