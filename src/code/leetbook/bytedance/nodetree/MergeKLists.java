package code.leetbook.bytedance.nodetree;

import entity.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Desc MergeKLists
 * @date 2020/9/21
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(l -> l.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.offer(listNode);
            }
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!queue.isEmpty()) {
            ListNode first = queue.poll();
            cur.next = first;
            cur = cur.next;

            if (first.next != null) {
                queue.offer(first.next);
            }
        }
        return head.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length < 1) {
            return lists[0];
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = mergeLists(lists, left, mid);
        ListNode l2 = mergeLists(lists, mid + 1, right);
        return merge2(l1, l2);
    }

    private ListNode merge2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l1;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge2(l1, l2.next);
            return l1;
        } else {
            l2.next = merge2(l1.next, l2);
            return l2;
        }
    }

}
