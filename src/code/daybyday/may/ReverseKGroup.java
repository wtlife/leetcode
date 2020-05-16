package code.daybyday.may;

import entity.ListNode;

import java.util.List;

/**
 * 25. K 个一组翻转链表
 */
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        ListNode start = pre;
        ListNode end = pre;
        ListNode next;
        while (end.next != null) {

            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            start = pre.next;
            next = end.next;
            end.next = null;

            //start已成为末尾
            pre.next = reverse(start);

            //接上链表末尾
            start.next = next;
            pre = start;
            end = pre;
        }

        return hair.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
        return pre;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        // 用于记录头节点返回
        ListNode hair = pre;

        ListNode start = pre.next, next;
        ListNode end = pre;

        while (end.next != null) {
            // 移动tail到小段链表末尾
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            next = end.next;
            start = pre.next;
            end.next = null;

            // 反转链表（head，tail
            pre.next = reverse(start);

            // 接上链表末尾,此时start为反转后链表末尾
            start.next = next;
            pre = start;
            end = pre;
        }
        return hair.next;
    }

}
