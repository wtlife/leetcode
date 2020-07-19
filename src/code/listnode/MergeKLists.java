package code.listnode;

import entity.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Desc 23.MergeKLists
 * @date 2020/7/19
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparing(o -> o.val));
        for (ListNode n : lists) {
            if (n==null) continue;
            queue.offer(n);
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
}
