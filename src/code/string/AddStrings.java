package code.string;


/**
 * 415. 字符串相加
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        for (int i = num2.length(); i < num1.length(); i++) {
            num2 = "0" + num2;
        }
        String res = "";
        int zero = (int) '0';
        int next = 0;
        int cur;
        for (int i = num1.length() - 1; i >= 0; i--) {
            cur = next;
            int n1 = (int) num1.charAt(i) - zero;
            int n2 = (int) num2.charAt(i) - zero;
            cur = cur + n1 + n2;
            next = cur / 10;
            cur = cur % 10;
            res = cur + res;
        }
        if (next != 0) {
            res = next + res;
        }
        return res;
    }
}
