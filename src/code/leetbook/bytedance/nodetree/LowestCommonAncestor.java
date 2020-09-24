package code.leetbook.bytedance.nodetree;

import entity.TreeNode;

/**
 * @Desc LowestCommonAncestor
 * @date 2020/9/21
 */
public class LowestCommonAncestor {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return ans;
    }

    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean mid = root.val == p.val || root.val == q.val;
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);

        if ((mid & (left || right)) || (left & right)){
            ans = root;
        }

        return mid||left||right;
    }
}
