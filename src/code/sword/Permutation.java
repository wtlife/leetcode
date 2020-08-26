package code.sword;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Desc 38.Permutation
 * @date 2020/8/23
 */
public class Permutation {

    List<String> res = new ArrayList<>();
    char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        helper(0);
        return res.toArray(new String[res.size()]);
    }

    private void helper(int x) {
        if (x == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }
        Set<Character> visited = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (visited.contains(chars[i])){
                continue;
            }
            visited.add(chars[i]);
            swap(i, x);
            helper(x + 1);
            swap(i, x);
        }
    }

    private void swap(int i, int x) {
        char tmp = chars[i];
        chars[i] = chars[x];
        chars[x] =tmp;
    }
}
