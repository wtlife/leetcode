package code.daybyday.may;

import entity.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        helper(root, p, q);
        return ans;
    }

    private boolean helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }

        boolean mid = node.val == p.val || node.val == q.val;
        boolean left = helper(node.left, p, q);
        boolean right = helper(node.right, p, q);

        if (left && right || mid && (left || right)) {
            ans = node;
        }
        return mid || left || right;

    }
}
