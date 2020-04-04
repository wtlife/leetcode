package code.daybyday;

import java.util.Stack;

public class Trap {
    public int trap(int[] height) {
        int size = height.length;
        int ans = 0;
        for (int i = 1; i < size; i++) {
            int maxLeft = 0;
            for (int left = i; left >= 0; left--) {
                maxLeft = Math.max(maxLeft, height[left]);
            }
            int maxRight = 0;
            for (int right = i; right < size; right++) {
                right = Math.max(maxRight, height[right]);
            }

            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }

    public int trap2(int[] height) {
        int size = height.length;
        int ans = 0;
        if (size == 0) {
            return 0;
        }
        int[] maxLeft = new int[size];
        int[] maxRight = new int[size];

        maxLeft[0] = height[0];
        for (int i = 1; i < size; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        maxRight[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        for (int i = 0; i < size; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return ans;
    }

    public int trap3(int[] height) {
        int cur = 0;
        int size = height.length;
        int ans = 0;

        Stack<Integer> stack = new Stack<>();
        while (cur < size) {
            while (!stack.isEmpty() && height[stack.peek()] < height[cur]) {
                int top = stack.peek();
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = cur - stack.peek() - 1;
                int bounded_height = Math.min(height[cur], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(cur++);
        }
        return ans;
    }

}
