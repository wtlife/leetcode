package code.listnode;

import entity.ListNode;

/**
 * @Desc 25.ReverseKGroup
 * @date 2020/7/24
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode(0);
        h.next = head;

        ListNode pre = h;
        ListNode start = pre;
        ListNode end = pre;

        while (end.next != null) {
            for (int i = 0; i < k && end!=null; i++) {
                end = end.next;
            }

            if (end == null) {
                break;
            }
            //记录连接处,然后截断
            ListNode connect = end.next;
            end.next = null;

            start = pre.next;
            //此时start为最后一个节点,连接截断处
            pre.next = reverse(start);
            start.next = connect;

            pre = start;
            end = pre;
        }

        return h.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode pre = null;
        ListNode cur = start;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
