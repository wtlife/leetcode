package code.listnode;

import entity.ListNode;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 */
public class KthToLast {
    public int kthToLast(ListNode head, int k) {
        ListNode fast, slow;
        fast = slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow.val;
    }
}
