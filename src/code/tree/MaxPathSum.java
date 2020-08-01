package code.tree;

import entity.TreeNode;

/**
 * @Desc 124. MaxPathSum
 * @date 2020/8/1
 */
public class MaxPathSum {

    private int res = 0;

    public int maxPathSum(TreeNode root) {
        recursive(root);
        return res;
    }

    // 获取节点最大贡献值
    private int recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(recursive(root.left), 0);
        int right = Math.max(recursive(root.right), 0);

        //更新最大路径/最大路径为节点值加左右节点的最大贡献值
        int tmp = root.val + left + right;
        res = Math.max(tmp, res);

        //最大贡献值为节点值+左节点或右节点的最大贡献值
        return root.val + Math.max(left, right);
    }

}
