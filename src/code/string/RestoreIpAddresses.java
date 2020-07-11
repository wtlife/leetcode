package code.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {

                        if (a + b + c + d == s.length()) {

                            int int1 = Integer.parseInt(s.substring(0, a));
                            int int2 = Integer.parseInt(s.substring(a, a + b));
                            int int3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int int4 = Integer.parseInt(s.substring(a + b + c));

                            if (int1 <= 255 && int2 <= 255 && int3 <= 255 && int4 <= 255) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(int1).append(".")
                                        .append(int2).append(".")
                                        .append(int3).append(".")
                                        .append(int4);
                                if (sb.toString().length() == s.length() + 3) {
                                    res.add(sb.toString());
                                }
                            }

                        }
                    }
                }
            }
        }

        return res;
    }


    public List<String> restoreIpAddresses2(String s) {
        List<String> res = new ArrayList<>();
        backTrack("", 0, 4, s, s.length(), res);
        return res;
    }

    public void backTrack(String tmp, Integer i, Integer flag, String s, Integer n, List<String> res) {
        if (i.equals(n) && flag == 0) {
            res.add(tmp.substring(0, tmp.length() - 1));
            return;
        }
        if (flag < 0) {
            return;
        }
        for (int j = i; j < i + 3; j++) {
            if (j < n) {
                if (j == i && s.charAt(j) == '0') {
                    backTrack(tmp + "0.", j + 1, flag - 1, s, n, res);
                    break;
                }

                if (Integer.parseInt(s.substring(i, j + 1)) <= 255) {
                    backTrack(tmp + s.substring(i, j+1) + ".", j + 1, flag - 1, s, n, res);
                }
            }
        }
    }

}

