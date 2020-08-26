package code.sword;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 31.ValidateStackSequences
 * @date 2020/8/19
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped == null || pushed == null || pushed.length != popped.length) {
            return false;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while (i < pushed.length && j < popped.length) {

            while (i < pushed.length && pushed[i] != popped[j]) {
                stack.addLast(pushed[i]);
                i++;
            }
            while (i < pushed.length && pushed[i] == popped[j]) {
                i++;
                j++;
            }

            while (!stack.isEmpty() && stack.peekLast() == popped[j]) {
                stack.pollLast();
                j++;
            }

        }
        return stack.isEmpty();
    }
}
