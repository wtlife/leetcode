package code.listnode;

import entity.ListNode;

/**
 * @Desc 160. GetIntersectionNode
 * @date 2020/7/24
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA!= hB) {

            hA = hA == null ? headB : hA.next;
            hB = hB == null ? headA : hB.next;

        }
        return hA;
    }
}
