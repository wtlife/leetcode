package code.tree;

import entity.TreeNode;

/**
 * 783. 二叉搜索树节点最小距离
 */
public class MinDiffInBST {
    Integer prev, min;

    public int minDiffInBST(TreeNode root) {
        prev = null;
        min = Integer.MAX_VALUE;
        helper(root);
        return min;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        if (prev != null) {
            min = Math.min(min, node.val - prev);
        }
        prev = node.val;
        helper(node.right);
    }

}
