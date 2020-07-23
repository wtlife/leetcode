package code.listnode;

import entity.ListNode;

/**
 * @Desc 143.ReorderList
 * @date 2020/7/23
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // slice
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse
        ListNode cur = slow.next;
        slow.next = null;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        // merge
        ListNode h = new ListNode(0);
        h.next = head;
        while (head != null&&pre!=null) {
            ListNode tmp1 = head.next;
            ListNode tmp2 = pre.next;

            head.next = pre;
            pre.next = tmp1;

            head = tmp1;
            pre = tmp2;
        }

        head = h.next;
    }
}
