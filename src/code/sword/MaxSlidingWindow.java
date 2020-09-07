package code.sword;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 59-1.MaxSlidingWindow
 * @date 2020/9/4
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int right = 0; right < nums.length; right++) {
            int left = right - k + 1;
            while (!deque.isEmpty() && nums[right] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(right);
            while (left > deque.peekFirst()) {
                deque.pollFirst();
            }

            if (left>= 0) {
                res[left] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
