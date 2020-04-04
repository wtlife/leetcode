package code.tree;

import entity.TreeNode;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = dep(root.left);
        int right = dep(root.right);
        return Math.abs(left) - Math.abs(right) > 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int dep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dep(node.left);
        int right = dep(node.right);
        return Math.max(left, right) + 1;
    }


    public boolean isBalanced2(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
