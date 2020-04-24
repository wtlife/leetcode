package code.tree;

import entity.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        TreeNode res = root;
        while (res != null) {
            if (res.val > val) {
                res = res.left;
                continue;
            }
            if (res.val < val) {
                res = res.right;
                continue;
            }
            return res;
        }

        return null;
    }
}
