package code.listnode;

import entity.ListNode;

/**
 * 141. 环形链表
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow==fast) {
                return true;
            }
        }
        return false;
    }
}
