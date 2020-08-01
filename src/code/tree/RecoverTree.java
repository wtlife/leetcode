package code.tree;

import entity.TreeNode;

/**
 * @Desc 99.RecoverTree
 * @date 2020/8/1
 */
public class RecoverTree {

    TreeNode first =null;
    TreeNode second=null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int tmp =first.val;
        first.val= second.val;
        second.val=tmp;
    }

    private void inOrder(TreeNode root) {
        if (root==null){
            return;
        }
        inOrder(root.left);
        if (first==null && preNode.val>root.val){
            first=preNode;
        }
        if (first!=null && preNode.val>root.val){
            second= root;
        }

        preNode = root;
        inOrder(root.right);
    }
}
