package code.tree;

import entity.TreeNode;

public class FindSecondMinimumValue {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return helper(root, root.val);
    }

    private int helper(TreeNode root, int min) {
        if (root == null) {
            return -1;
        }
        if (root.val > min) {
            return root.val;
        }
        int left = helper(root.left, min);
        int right = helper(root.right, min);
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }

        return Math.min(left, right);
    }
}
