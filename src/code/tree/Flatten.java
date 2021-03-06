package code.tree;

import entity.TreeNode;

/**
 * 114. 二叉树展开为链表
 */
public class Flatten {

    public void flatten(TreeNode root) {
        helper(root);
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        helper(root.right);
        if (root.left != null) {
            TreeNode pre = root.left;
            while (pre.right != null) {
                pre = pre.right;
            }
            pre.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
    public void flatten2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }

}
