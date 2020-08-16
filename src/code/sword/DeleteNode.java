package code.sword;

import entity.ListNode;

/**
 * @Desc 18.DeleteNode
 * @date 2020/8/16
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            head = head.next;
            return head;
        }

        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                break;
            }
            pre = pre.next;
            cur = cur.next;
        }

        return head;
    }
}
