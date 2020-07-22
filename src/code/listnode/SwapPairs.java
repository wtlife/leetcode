package code.listnode;

import entity.ListNode;


/**
 * @Desc SwapPairs
 * @date 2020/7/21
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null) {
            ListNode start = cur.next;
            ListNode end = cur.next.next;

            //
            cur.next = end;

            start.next = end.next;
            end.next = start;

            cur = start;
        }

        return pre.next;
    }

}
