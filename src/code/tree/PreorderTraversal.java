package code.tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode first = stack.pop();
            res.add(first.val);
            if (first.right != null) {
                stack.push(first.right);
            }

            if (first.left != null) {
                stack.push(first.left);
            }
        }
        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node==null){
            return;
        }
        res.add(node.val);
        helper(node.left,res);
        helper(node.right,res);
    }

}

