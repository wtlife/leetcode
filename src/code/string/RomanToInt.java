package code.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 */
public class RomanToInt {
    public int romanToInt(String s) {
        int res = 0;
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("I", 1);
            put("IV", 4);
            put("V", 5);
            put("IX", 9);
            put("X", 10);
            put("XL", 40);
            put("L", 50);
            put("XC", 90);
            put("C", 100);
            put("CD", 400);
            put("D", 500);
            put("CM", 900);
            put("M", 1000);
        }};
        for (int i = 0; i < s.length(); ) {
            String tmp = String.valueOf(s.charAt(i));
            if (tmp.equals("I") || tmp.equals("X") || tmp.equals("C")) {
                if (i <= s.length() - 2 && map.get(s.substring(i, i + 2)) != null) {
                    res += map.get(s.substring(i, i + 2));
                    i += 2;
                } else {
                    res += map.get(tmp);
                    i++;
                }
            } else {
                res += map.get(tmp);
                i++;
            }

        }
        return res;
    }

    public int romanToInt2(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
