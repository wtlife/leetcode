package code.leetbook.bytedance.str;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc RestoreIpAddresses
 * @date 2020/9/10
 */
public class RestoreIpAddresses {
    List<String> list = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTrack("", 0, s, 4);
        return list;
    }

    public void backTrack(String res, int idx, String s, int flag) {
        if (idx == s.length() && flag==0) {
            list.add(res.substring(0, res.length() - 1));
            return;
        }
        if (flag < 0) {
            return;
        }

        for (int i = idx; i < idx + 3 && i < s.length(); i++) {

            char curChar = s.charAt(i);
            if (i==idx &&Character.getNumericValue(curChar) == 0) {
                backTrack(res + s.substring(idx, i + 1) + ".", i + 1, s, flag-1);
                break;
            }

            int num = Integer.parseInt(s.substring(idx, i + 1));
            if (num > 0 && num <= 255) {
                backTrack(res + num + ".", i + 1, s, flag-1);
            }

        }
    }

}
