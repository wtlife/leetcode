package code.listnode;

import entity.ListNode;

/**
 * @Desc 203. RemoveElements
 * @date 2020/7/26
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode cur = new ListNode(-1);
        cur.next = head;
        ListNode h = cur;

        while (cur.next != null) {
            ListNode tmp = cur.next;
            if (tmp.val == val) {
                cur.next = tmp.next;
            } else {
                cur = tmp;
            }
        }

        return h.next;
    }
}
