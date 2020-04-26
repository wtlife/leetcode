package code.daybyday;

import entity.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23.
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) {
            return lists[lo];
        }
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);
        return merge2Lists(l1, l2);
    }


    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        }
        l2.next = merge2Lists(l1, l2.next);
        return l2;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0), cur = head;
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node == null) {
                continue;
            }
            queue.offer(node);
        }
        while (!queue.isEmpty()) {
            ListNode first = queue.poll();
            cur.next = first;
            cur = cur.next;
            if (first.next != null) {
                first = first.next;
                queue.offer(first);
            }
        }

        return head.next;
    }

}
