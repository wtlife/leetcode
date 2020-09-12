package code.leetbook.bytedance.str;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc SimplifyPath
 * @date 2020/9/10
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] items = path.split("/");
        for (String item : items) {
            if ("".equals(item) || ".".equals(item)) {
                continue;
            }
            if ("..".equals(item)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
                continue;
            }
            stack.addLast(item);
        }

        if (stack.isEmpty()) {
            return "/";
        }

        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pollLast() + res;
        }
        return res;
    }
}
