package code.listnode;

import entity.ListNode;

/**
 * 21. 合并两个有序链表
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }


    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {

                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                }

            } else {

                if (l1 != null) {
                    cur.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                if (l2 != null) {
                    cur.next = new ListNode(l2.val);
                    l2 = l2.next;
                }

            }
            cur = cur.next;
        }

        return head.next;
    }
}
