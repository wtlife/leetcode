package code.tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序查找树
 */
public class IncreasingBST {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> valList = new ArrayList<>();
        inOrder(root, valList);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (Integer val : valList) {
            cur.right= new TreeNode(val);
            cur= cur.right;
        }
        return ans.right;
    }

    private void inOrder(TreeNode root, List<Integer> valList) {
        if (root == null) return;
        inOrder(root.left, valList);
        valList.add(root.val);
        inOrder(root.right, valList);
    }
}
