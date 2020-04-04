package code.tree;

import entity.TreeNode;

public class GetMinimumDifference {
    int res = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre != null) {
            res = Math.min(res, Math.abs(root.val - pre.val));
        }
        pre = root;
        inOrder(root.right);
    }

}
