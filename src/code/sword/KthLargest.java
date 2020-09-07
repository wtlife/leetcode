package code.sword;

import entity.TreeNode;

/**
 * @Desc 54.KthLargest
 * @date 2020/9/3
 */
public class KthLargest {

    int res = 0;
    int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.right);
        k--;
        if (k == 0) {
            res = root.val;
            return;
        }
        helper(root.left);

    }
}
