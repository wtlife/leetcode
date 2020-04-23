package code.tree;

import entity.TreeNode;

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
