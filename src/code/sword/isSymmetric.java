package code.sword;

import entity.TreeNode;

/**
 * @Desc 28.isSymmetric
 * @date 2020/8/18
 */
public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        boolean res = isSymmetric(root,root);
        return res;
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1==null && root2==null){
            return true;
        }
        if (root1==null || root2==null){
            return false;
        }
        if (root1.val!=root2.val){
            return false;
        }
        return isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left);
    }
}
