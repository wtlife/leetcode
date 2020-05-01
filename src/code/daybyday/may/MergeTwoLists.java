package code.daybyday.may;

import entity.ListNode;

/**
 * 21. 合并两个有序链表
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }

        ListNode first = new ListNode(0), cur = first;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return first.next;
    }
}
