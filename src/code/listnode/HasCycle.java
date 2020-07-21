package code.listnode;

import entity.ListNode;

/**
 * 141. 环形链表
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head==null||head.next==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast!=null&& fast.next!=null){
            if (fast.val==slow.val){
                return true;
            }
            slow = slow.next;
            fast=fast.next.next;

        }
        return false;
    }
}
