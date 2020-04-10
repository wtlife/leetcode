package code.daybyday;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String s) {
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }

        if (left > 0) {
            dfs(left-1, right, s + "(");
        }
        if (right > left) {
            dfs(left, right-1, s + ")");
        }
    }
}
