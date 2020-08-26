package code.sword;

/**
 * @Desc 37.TreeToDoublyList
 * @date 2020/8/23
 */
public class TreeToDoublyList {

    Node head,pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        helper(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void helper(Node cur) {
        if (cur==null){
            return;
        }
        helper(cur.left);

        if (pre!= null) {
            pre.right = cur;
        }else {
            head = cur;
        }

        cur.left = pre;
        pre = cur;

        helper(cur.right);
    }


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
