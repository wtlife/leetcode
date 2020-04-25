package code.tree;

import entity.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 */
public class SumRootToLeaf {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return -1;
        }
        helper(root,0);
        return sum;
    }

    private void helper(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        num += root.val;
        if(root.left==null && root.right==null){
            sum+= num;
        }
        helper(root.left, num * 2);
        helper(root.right, num * 2);
    }
}
