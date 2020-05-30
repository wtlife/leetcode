package code.daybyday.may;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. 柱状图中最大的矩形
 */
public class LargestRectangleArea {
    //暴力
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int len = heights.length;
        for (int i = 0; i < len; i++) {
            int height = heights[i];
            int left = i, right = i;
            while (left >= 0 && heights[left] >= height) {
                left--;
            }
            while (right < len && heights[right] >= height) {
                right++;
            }
            int area = (right - left + 1) * height;
            res = Math.max(area, res);
        }

        return res;
    }


    /**
     * 单调栈解法
     * 栈内维护的是高度单调递增的
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights == null) {
            return 0;
        }
        int len = heights.length;
        if (len == 1) {
            return heights[0];
        }

        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];
                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                    stack.removeLast();
                }

                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }
                ans = Math.max(ans, width * height);

            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.removeLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                stack.removeLast();
            }

            int width;
            if (stack.isEmpty()) {
                width = len;
            } else {
                width = len - stack.peekLast() - 1;
            }
            ans = Math.max(ans, height * width);
        }
        return ans;
    }
}

