package code.listnode;

import entity.ListNode;

/**
 * @Desc 237.DeleteNode
 * @date 2020/7/19
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
