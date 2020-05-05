package code.tree;

import entity.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;

        while (root != null) {
            int rootVal = root.val;
            if (pVal > rootVal && qVal > rootVal) {
                root = root.right;
            } else if (pVal < rootVal && qVal < rootVal) {
                root = root.left;
            } else {
                return root;
            }
        }

        return root;

    }
}
