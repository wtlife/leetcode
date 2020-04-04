package code.tree;

import entity.TreeNode;

public class SumOfLeftLeaves {
    private int res =0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null){
            return res;
        }
        if (root.left!=null){
            boolean isLeaf = root.left.left==null&&root.left.right==null;
            if (isLeaf){
                res += root.left.val;
            }
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return res;
    }
}
