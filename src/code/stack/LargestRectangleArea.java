package code.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 84. LargestRectangleArea
 * @date 2020/8/4
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] heightsTmp = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            heightsTmp[i + 1] = heights[i];
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int cur = 0; cur < heightsTmp.length; cur++) {
            while (!stack.isEmpty() && heightsTmp[cur] < heightsTmp[stack.peekLast()]) {
                int height = heightsTmp[stack.pollLast()];
                int width = cur - stack.peekLast() - 1;
                int area = height * width;
                res = Math.max(area, res);
            }
            stack.addLast(cur);
        }

        return res;
    }

}
