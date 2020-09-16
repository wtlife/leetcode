package code.leetbook.bytedance.arrsort;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc Trap
 * @date 2020/9/15
 */
public class Trap {
    public int trap(int[] height) {
        int res = 0;
        if (height.length < 1) {
            return res;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                int bottom = height[stack.pollLast()];
                if (stack.isEmpty()){
                    break;
                }
                int wid = i - stack.peekLast()-1;
                int hi = Math.min(height[i],height[stack.peekLast()])-bottom;
                int area = wid * hi;
                res+=area;
            }

            stack.addLast(i);
        }
        return res;
    }
}
