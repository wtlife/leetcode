package code.sword;

import entity.TreeNode;

/**
 * @Desc 68-2.LowestCommonAncestor2
 * @date 2020/9/6
 */
public class LowestCommonAncestor2 {

    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }

    private boolean helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean left = helper(node.left, p, q);
        boolean mid = node.val == q.val || node.val == p.val;
        boolean right = helper(node.right, p, q);
        if (left && right || (mid && (right || left))) {
            ans = node;
        }

        return left || mid || right;
    }

}
