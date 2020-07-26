package code.listnode;

import entity.ListNode;

/**
 * @Desc 328. OddEvenList
 * @date 2020/7/26
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //奇数
        ListNode even = head;
        ListNode odd = head.next;
        ListNode hOdd = new ListNode(0);
        hOdd.next =odd;


        while (even.next != null && odd.next != null) {
            ListNode evenTmp = even.next;
            even.next = evenTmp.next;
            even = even.next;

            odd.next = even.next;
            odd =odd.next ;
        }
        even.next = hOdd.next;

        return head;
    }
}
