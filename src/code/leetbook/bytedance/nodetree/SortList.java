package code.leetbook.bytedance.nodetree;

import entity.ListNode;

/**
 * @Desc SortList
 * @date 2020/9/20
 */
public class SortList {
    //使用归并排序的思想
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(next);

        ListNode ans = merge(left, right);
        return ans;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = new ListNode(left.val);
                left = left.next;
            } else {
                cur.next = new ListNode(right.val);
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left == null ? right : left;
        return head.next;
    }


    public ListNode findMid(ListNode node) {
        ListNode fast = node.next;
        ListNode slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
