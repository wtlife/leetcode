package code.sword;

import entity.TreeNode;

/**
 * @Desc 27.MirrorTree
 * @date 2020/8/18
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null){
            return root;
        }
        if (root.left==null && root.right==null){
            return root;
        }
        TreeNode left = root.left;
        root.left =root.right;
        root.right =left;
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}
