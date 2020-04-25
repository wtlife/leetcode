package code.tree;

import entity.TreeNode;

/**
 * 938. 二叉搜索树的范围和
 */
public class RangeSumBST {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return sum;
        }

        dfs(root, L, R);
        return sum;
    }

    private void dfs(TreeNode root, int l, int r) {
        if (root == null) {
            return;
        }
        if (root.val >= l && root.val <= r) {
            sum += root.val;
            dfs(root.left, l, r);
            dfs(root.right, l, r);
        }
        if (root.val < l) {
            dfs(root.right, l, r);
        }
        if (root.val > r) {
            dfs(root.left, l, r);
        }

    }
}
