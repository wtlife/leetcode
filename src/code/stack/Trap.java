package code.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 42. Trap
 * @date 2020/8/2
 */
public class Trap {
    public int trap(int[] height) {

        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int cur= 0; cur <height.length ; cur++) {
            while (!stack.isEmpty() && height[cur]>height[stack.peekLast()] ){
                int top = height[stack.pollLast()];
                if (stack.isEmpty()){
                    break;
                }

                int width = cur - stack.peekLast()-1;
                int heighth=  Math.min(height[cur],height[stack.peekLast()]) - top;
                area += width * heighth;
            }
            stack.addLast(cur);
        }

        return area;
    }
}
