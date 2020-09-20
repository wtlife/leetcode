package code.leetbook.bytedance.nodetree;

import entity.ListNode;


/**
 * @Desc AddTwoNumbers
 * @date 2020/9/20
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int prefix = 0;
        while (l1 != null || l2 != null) {
            int sum = prefix;
            if (l1 != null) {
                sum +=  l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum +=  l2.val;
                l2 = l2.next;
            }

            int val = sum % 10;
            prefix = sum / 10;

            cur.next = new ListNode(val);
            cur = cur.next;
        }
        if (prefix != 0) {
            cur.next = new ListNode(prefix);
        }

        return head.next;
    }
}
