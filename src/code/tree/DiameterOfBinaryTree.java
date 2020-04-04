package code.tree;

import entity.TreeNode;

/**
 * Definition for a binary classic.tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

public class DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDep = dfs(root.left);
        int rightDep = dfs(root.right);
        max = Math.max(leftDep + rightDep, max);
        return Math.max(leftDep, rightDep) + 1;
    }

}
