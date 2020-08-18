package code.sword;

import entity.TreeNode;

/**
 * @Desc IsSubStructure
 * @date 2020/8/18
 */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null ||B ==null){
            return false;
        }
        return dfs(A,B) || isSubStructure(A.left,B)|| isSubStructure(A.right,B);
    }

    private boolean dfs(TreeNode a, TreeNode b) {
        if (b==null){
            return true;
        }
        if ( a==null || a.val!=b.val){
            return false;
        }
        return dfs(a.left, b.left) && dfs(a.right, b.right);
    }
}
