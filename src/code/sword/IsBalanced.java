package code.sword;

import entity.TreeNode;

/**
 * @Desc 55-2.IsBalanced
 * @date 2020/9/3
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(helper(root.left) - helper(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        return Math.max(left, right)+1;
    }
}
