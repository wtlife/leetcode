package code.sword;

import java.util.HashMap;

/**
 * @Desc 50.FirstUniqChar
 * @date 2020/9/2
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (char c : sc)
            if (dic.get(c)) return c;
        return ' ';

    }
}
