package code.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 42. 接雨水
 */
public class Trap {

    //暴力
    public int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            for (int j = i; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }


    //单调栈解法
    public int trap2(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        int current = 0;
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peekLast()]) {
                Integer top = stack.pollLast();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = current - stack.peekLast() - 1;
                int tempHeight = Math.min(height[current], height[stack.peekLast()]) - height[top];
                int tempArea = tempHeight * distance;
                area += tempArea;
            }

            stack.addLast(current);
            current++;
        }
        return area;
    }

    //双指针
    public int trap3(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    ans += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }

        return ans;
    }
}
