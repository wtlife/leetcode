package code.leetbook.bytedance.nodetree;

import entity.ListNode;

/**
 * @Desc GetIntersectionNode
 * @date 2020/9/21
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            curA = curA== null ? headB : curA.next;
            curB = curB== null ? headA : curB.next;
        }
        return curA;
    }
}
