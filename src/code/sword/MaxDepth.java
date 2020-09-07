package code.sword;

import entity.TreeNode;

/**
 * @Desc 55-1.MaxDepth
 * @date 2020/9/3
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
