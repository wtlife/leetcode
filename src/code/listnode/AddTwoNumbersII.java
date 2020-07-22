package code.listnode;

import entity.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc AddTwoNumbersII
 * @date 2020/7/22
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        while (l1 != null) {
            stack1.addLast(l1.val);
            l1=l1.next;
        }
        while (l2 != null) {
            stack2.addLast(l2.val);
            l2=l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() ||carry>0) {
            int sum = carry;

            int i1 = stack1.isEmpty() ? 0 : stack1.pollLast();
            int i2 = stack2.isEmpty() ? 0 : stack2.pollLast();
            sum = (sum + i1 + i2);
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
        }
        return head;

    }
}
