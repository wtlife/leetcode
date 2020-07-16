package code.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z字形变换
 */
public class Convert {
    public String convert(String s, int numRows) {
        if (s.length()<2){
            return s;
        }
        StringBuilder res = new StringBuilder();
        List<StringBuilder> resList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            resList.add(new StringBuilder());
        }

        int i = 0;
        int flag = -1;

        for (char c : s.toCharArray()) {
            resList.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        resList.forEach(res::append);
        return res.toString();
    }
}
