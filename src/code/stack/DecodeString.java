package code.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 394. DecodeString
 * @date 2020/8/9
 */
public class DecodeString {
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ']') {
                //字符串
                String strTmp = "";
                while (!stack.isEmpty() && !stack.peekLast().equals("[")) {

                    strTmp =  stack.pollLast() + strTmp;
                }
                stack.pollLast();

                //字符串前的数字
                String cntStr = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peekLast().charAt(0))) {
                    cntStr = stack.pollLast() + cntStr;
                }
                Integer cnt = Integer.valueOf(cntStr);


                //组合
                String tmp ="";
                for (int j = 0; j < cnt; j++) {
                    tmp += strTmp;
                }

                //再入栈
                stack.addLast(tmp);
            } else {
                stack.addLast(String.valueOf(cur));
            }
        }
        while (!stack.isEmpty()){
            res += stack.pollLast();
        }
        return res;
    }
}
