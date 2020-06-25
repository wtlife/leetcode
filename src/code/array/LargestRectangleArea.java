package code.array;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. 柱状图中的最大矩形
 */
public class LargestRectangleArea {

    /**
     * 暴力
     * 控制变量，固定高度
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int left = i;
            int right = i;

            while (left - 1 >= 0 && heights[left - 1] >= height) {
                left--;
            }
            while (right + 1 < heights.length && heights[right + 1] >= height) {
                right++;
            }
            int width = right - left + 1;
            ans = Math.max(ans, width * height);

        }
        return ans;
    }


    /**
     * 单调栈
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {
                int height = heights[stack.removeLast()];
                //栈中高度相等
                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                    stack.removeLast();
                }

                int width;
                //弹栈后栈为空/那么当前元素总能扩散到最左边
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }
                int area = height * width;
                ans = Math.max(ans, area);
            }
            stack.addLast(i);
        }

        //遍历完后栈不为空
        while (!stack.isEmpty()) {
            int height = heights[stack.removeLast()];
            while (!stack.isEmpty() && height == stack.peekLast()) {
                stack.removeLast();
            }

            int width;
            if (stack.isEmpty()) {
                width = len;
            } else {
                width = len - stack.peekLast() - 1;
            }
            int area = height * width;
            ans = Math.max(area, ans);
        }

        return ans;
    }

}
