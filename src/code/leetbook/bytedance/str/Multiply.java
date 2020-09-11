package code.leetbook.bytedance.str;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc Multiply
 * @date 2020/9/10
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.length() > num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int resLen = num1.length() + num2.length();

        List<String> tmpList = new ArrayList<>();
        int idx = 0;
        for (int i = num1.length() - 1; i >= 0; i--, idx++) {
            int cur = Character.getNumericValue(num1.charAt(i));
            String multiplyTmp = multiplyCur(num2, cur);
            for (int j = 0; j < idx; j++) {
                multiplyTmp += "0";
            }
            while (multiplyTmp.length() != resLen) {
                multiplyTmp = "0" + multiplyTmp;
            }
            tmpList.add(multiplyTmp);
        }

        String res = add(tmpList);
        return res;
    }

    private String multiplyCur(String num2, int factor) {
        String res = "";
        int prefix = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int cur2 = Character.getNumericValue(num2.charAt(i));
            int tmp = cur2 * factor;
            tmp += prefix;

            prefix = tmp / 10;
            res = tmp % 10 + res;
        }
        if (prefix > 0) {
            res = prefix + res;
        }
        return res;
    }

    private String add(List<String> tmpList) {
        String res = "";
        int len = tmpList.get(0).length();
        for (int i = 0; i < tmpList.size(); i++) {
            if (i == 0) {
                res = tmpList.get(i);
                continue;
            }

            String num1 = res;
            String num2 = tmpList.get(i);

            res = "";
            int prefix = 0;
            for (int j = len - 1; j >= 0; j--) {
                int cur1 = Character.getNumericValue(num1.charAt(j));
                int cur2 = Character.getNumericValue(num2.charAt(j));
                int sum = cur1 + cur2 + prefix;

                prefix = sum / 10;
                res = sum % 10 + res;
            }

            if (prefix != 0) {
                res = prefix / 10 + res;
            }
        }
        int idx = 0;
        while (Character.getNumericValue(res.charAt(idx)) == 0) {
            idx++;
        }
        return res.substring(idx);
    }
}
