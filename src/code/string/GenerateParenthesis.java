package code.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", n, n, res);
        return res;
    }

    private void dfs(String s, int leftCnt, int rightCnt, List<String> res) {


        if (leftCnt == 0 && leftCnt == rightCnt) {
            res.add(s);
            return;
        }
        if (leftCnt > rightCnt) {
            return;
        }
        if (leftCnt > 0) {
            dfs(s + "(", leftCnt - 1, rightCnt, res);
        }

        if (rightCnt > leftCnt) {
            dfs(s + ")", leftCnt, rightCnt - 1, res);
        }

    }
}
