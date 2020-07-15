package code.offer;

import entity.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 06. 从尾到头打印链表
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        int count = 0;
        Deque<Integer> stack = new ArrayDeque();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] ans =new int[stack.size()];
        int i = stack.size()-1;
        while (!stack.isEmpty()){
            ans[i--] = stack.pollLast();
        }
        return ans;
    }
}
