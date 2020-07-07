package code.string;


/**
 * 67. 二进制求和
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        for (int i = b.length(); i < a.length(); i++) {
            b = "0" + b;
        }

        String res = "";
        int next = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            char A = a.charAt(i);
            char B = b.charAt(i);
            int cur = 0;
            if (next > 0) {
                cur = next;
            }

            if (A == '1' && B == '1') {
                cur += 2;
            } else if (A == '0' && B == '0') {
                cur += 0;
            } else {
                cur += 1;
            }

            res = cur % 2 + res;
            if (cur >= 2) {
                next = 1;
            }
            if (cur < 2) {
                next = 0;
            }

        }
        if (next > 0) {
            res = "1" + res;
        }

        return res;
    }
}
