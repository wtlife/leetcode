package code.tree;

import entity.TreeNode;

public class LowestCommonAncestor {
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
