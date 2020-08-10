package code.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc 496.NextGreaterElement
 * @date 2020/8/9
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int cur = nums2[i];
            while (!stack.isEmpty() && nums2[stack.peekLast()] < cur) {
                int peekVal = nums2[stack.pollLast()];
                map.put(peekVal,cur);
            }
            stack.addLast(i);
        }

        while (!stack.isEmpty()){
            map.put(nums2[stack.pollLast()],-1);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i <nums1.length ; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
