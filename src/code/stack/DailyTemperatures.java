package code.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 739.DailyTemperatures
 * @date 2020/8/3
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[T.length];

        for (int cur = 0; cur < T.length; cur++) {
            while (!stack.isEmpty() && T[cur] > T[stack.peekLast()]) {
                int top = stack.pollLast();
                res[top] = cur - top;
            }
            stack.addLast(cur);
        }

        return res;
    }
}
