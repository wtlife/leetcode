package code.listnode;

import entity.ListNode;

/**
 * @version V1.0
 * @Desc 206.ReverseList
 * @date 2020/7/19
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        while (cur!=null){

            ListNode next= cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }

        return pre;
    }
}
