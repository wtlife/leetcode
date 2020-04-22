package code.tree;

import entity.TreeNode;

/**
 * 687. 最长同值路径
 */
public class LongestUnivaluePath {
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    private int arrowLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int arrowLeft = arrowLength(root.left);
        int arrowRight = arrowLength(root.right);
        int left = 0, right = 0;
        if (root.left != null && root.left.val == root.val) {
            left = arrowLeft + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right = arrowRight + 1;
        }

        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }
}
