package code.listnode;

import entity.ListNode;

/**
 * @Desc 234. IsPalindrome
 * @date 2020/7/21
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode cur = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {

            cur = slow;

            //快慢指针移动
            slow = slow.next;
            fast = fast.next.next;

            //反转链表
            cur.next = pre;
            pre = cur;

        }
        ListNode p1 = slow.next;
        slow.next = pre;
        ListNode p2 = fast == null ? slow.next : slow;
        while (p1 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
