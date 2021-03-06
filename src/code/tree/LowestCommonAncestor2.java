package code.tree;

import entity.TreeNode;

/**
 * @Desc   二叉树的最近公共祖先
 * @date   2020/8/1
 */
public class LowestCommonAncestor2 {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurse(root, p, q);
        return ans;
    }

    private boolean recurse(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean left = recurse(node.left, p, q);
        boolean mid = node.val == p.val || node.val == q.val;
        boolean right = recurse(node.right, p, q);
        if ((left && right) || (mid && (left || right))) {
            ans = node;
        }
        return left || right || mid;
    }
}
