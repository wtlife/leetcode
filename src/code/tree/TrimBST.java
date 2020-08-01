package code.tree;

import entity.TreeNode;

/**
 * @Desc   669.trimBST
 * @date   2020/8/1
 */
public class TrimBST {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root==null){
            return null;
        }
        if (root.val<L){
            return trimBST(root.right,L,R);
        }
        if (root.val>R){
            return trimBST(root.left,L,R);
        }
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        return root;
    }
}
