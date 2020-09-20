package code.leetbook.bytedance.nodetree;

import entity.ListNode;

/**
 * @Desc ReverseList
 * @date 2020/9/20
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur!=null){
            ListNode next  = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
