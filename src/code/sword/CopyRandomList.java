package code.sword;


/**
 * @Desc 36.CopyRandomList
 * @date 2020/8/23
 */
public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;

        //copy node
        while (cur != null) {
            Node next = cur.next;
            Node tmp = new Node(cur.val);
            cur.next = tmp;
            tmp.next = next;

            cur = cur.next.next;
        }

        // copy random
        cur = head;
        while (cur != null && cur.next != null) {
            if (cur.random == null) {
                cur.next.random = null;
            } else {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //split
        cur = head;
        Node head2 = cur.next;
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
