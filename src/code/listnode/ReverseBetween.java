package code.listnode;

import entity.ListNode;

/**
 * @Desc 92.ReverseBetween
 * @date 2020/7/23
 */
public class ReverseBetween {

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode dummyH = h;
        for (int i = 1; i < m ; i++) {
            dummyH= dummyH.next;
        }

        ListNode cur = dummyH.next;
        ListNode h2 = null;
        ListNode tail = cur;


        for (int i = m; i <= n; i++) {
            ListNode tmp = cur.next;
            cur.next = h2;
            h2 = cur;
            cur = tmp;
        }
        tail.next = cur;
        dummyH.next = h2;

        return h.next;
    }
}
