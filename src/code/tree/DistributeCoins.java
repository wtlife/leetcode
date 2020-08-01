package code.tree;

import entity.TreeNode;

/**
 * @Desc 979. DistributeCoins
 * @date 2020/8/1
 */
public class DistributeCoins {
    int ans;

    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans += Math.abs(left) + Math.abs(right);
        return root.val + left + right;
    }
}
