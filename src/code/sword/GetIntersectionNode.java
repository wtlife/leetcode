package code.sword;

import entity.ListNode;

/**
 * @Desc 52.GetIntersectionNode
 * @date 2020/9/2
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA;
        ListNode hb  = headB;
        while (ha!= hb) {
            ha= ha== null ? headB : ha.next;
            hb= hb== null ? headA : hb.next;
        }
        return ha;
    }
}
