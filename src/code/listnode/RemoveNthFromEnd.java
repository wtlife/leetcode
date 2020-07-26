package code.listnode;

import entity.ListNode;

/**
 * @Desc 19.RemoveNthFromEnd
 * @date 2020/7/26
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = new ListNode(0);
        h.next = head;
        int idx = 0;
        while (h.next != null) {
            h = h.next;
            idx++;
        }

        idx -= n;
        if (idx<=0) {
            return head.next;
        }

        ListNode h2 = new ListNode(0);
        h2.next = head;
        while (idx > 0) {
            h2 = h2.next;
            idx--;
        }
        h2.next = h2.next.next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode fast = h;
        ListNode slow = h;
        while (n>0){
            fast = fast.next;
            n--;
        }

        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next=slow.next.next;
        return h.next;
    }
}
