package code.leetbook.bytedance.nodetree;

import entity.ListNode;

/**
 * @Desc DetectCycle
 * @date 2020/9/20
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast==null || fast.next==null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow){
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
