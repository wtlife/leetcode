package code.listnode;


/**
 * @Desc CopyRandomList
 * @date 2020/7/20
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 复制next节点
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
        }

        //复制random节点
        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        //截断
        cur = head;
        Node head2 = head.next;
        Node cur2 = head2;
        while (cur != null && cur.next != null) {
            Node next1 = cur2.next;
            Node next2 = cur2.next == null ? null : cur2.next.next;

            cur.next = next1;
            cur2.next = next2;

            cur = cur.next;
            cur2 = cur2.next;
        }
        return head2;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
