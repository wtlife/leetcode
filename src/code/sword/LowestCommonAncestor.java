package code.sword;

import entity.TreeNode;

/**
 * @Desc 68-1.LowestCommonAncestor
 * @date 2020/9/6
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        int pVal = p.val;
        int qVal = q.val;
        while (root!=null){

            if (root.val>p.val &&root.val>q.val){
                root = root.left;
            }else if (root.val<p.val && root.val<q.val){
                root=root.right;
            }else {
                return root;
            }
        }

        return null;
    }
}
