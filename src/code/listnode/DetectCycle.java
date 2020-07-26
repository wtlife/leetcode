package code.listnode;

import entity.ListNode;

/**
 * 142. 环形链表 II
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head.next, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
