package code.listnode;

import entity.ListNode;

/**
 * @Desc 147.InsertionSortList
 * @date 2020/7/23
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        ListNode h = new ListNode(0);
        h.next = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val > cur.val) {
                cur = cur.next;
                continue;
            }
            ListNode dummy = h;
            while (cur.next.val > dummy.next.val) {
                dummy = dummy.next;
            }

            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = dummy.next;
            dummy.next =tmp ;

        }

        return h.next ;
    }
}
