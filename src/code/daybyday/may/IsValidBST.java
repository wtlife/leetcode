package code.daybyday.may;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 */

public class IsValidBST {

    int pre = Integer.MIN_VALUE;
    List<Integer> resList = new ArrayList<>();

    public boolean isValidBST1(TreeNode root) {
        helper(root);
        boolean res = true;
        if (resList.size() < 2) {
            return true;
        }
        for (int i = 1; i < resList.size(); i++) {
            if (resList.get(i - 1) >= resList.get(i)) {
                return false;
            }
        }

        return res;
    }

    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        resList.add(node.val);
        helper(node.right);
    }


    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST2(root.left)) {
            return false;
        }
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;
        return isValidBST2(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double pre= -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }
            pre= root.val;
            root = root.right;
        }
        return true;
    }

}
