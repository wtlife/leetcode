package code.listnode;

import entity.ListNode;

/**
 * @Desc 2.AddTwoNumbers
 * @date 2020/7/19
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            cur.next = node;
            cur = cur.next;


        }

        if (carry !=0){
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
