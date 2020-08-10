package code.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Desc 503.NextGreaterElements
 * @date 2020/8/9
 */
public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(res, -1);
        for (int i = 0; i < len * 2; i++) {
            int cur = nums[i % len];
            while (!stack.isEmpty() && cur > nums[stack.peekLast()]) {
                int peek = stack.pollLast();
                res[peek % nums.length] = cur;
            }
            stack.addLast(i % len);
        }
        return res;
    }
}
