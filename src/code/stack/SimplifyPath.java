package code.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 71.SimplifyPath
 * @date 2020/8/9
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] paths = path.split("/");
        for (String item : paths) {

            if (item.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!item.isEmpty() && !item.equals(".")) {
                stack.push(item);
            }
        }

        String res = "";
        while (!stack.isEmpty()) {
            res = res + "/" + stack.pollLast();
        }

        return res.isEmpty() ? "/" : res;
    }
}
