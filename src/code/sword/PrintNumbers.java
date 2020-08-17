package code.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 17.PrintNumbers
 * @date 2020/8/16
 */
public class PrintNumbers {
    List<String> strings = new ArrayList<>();
    char[] num;
    char[] loop = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        num = new char[n];
        dfs(0, n);
        strings = strings.subList(1, strings.size());
        int[] res = new int[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            String cur = strings.get(i);
            int tmp = Integer.parseInt(cur);
            res[i] = tmp;
        }
        return res;
    }

    private void dfs(int x, int n) {
        if (x == n) {
            String tmp = removeZero(String.valueOf(num));
            strings.add(tmp);
            return;
        }
        for (char cur : loop) {
            num[x] = cur;
            dfs(x + 1, n);
        }
    }

    private String removeZero(String str) {
        int idx = 0;
        for (char c : str.toCharArray()) {
            if (c != '0') {
                break;
            }
            idx++;
        }
        return str.substring(idx);
    }
}
