package code.tree;

import entity.TreeNode;

import java.util.Stack;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();

        nodeStack.add(root);
        valueStack.add(sum - root.val);
        while (!nodeStack.isEmpty()) {
            TreeNode first = nodeStack.pop();
            Integer value = valueStack.pop();
            if (first.left == null && first.right == null && value == 0) {
                return true;
            }
            if (first.right != null) {
                nodeStack.push(first.right);
                valueStack.push(value - first.right.val);
            }
            if (first.left != null) {
                nodeStack.push(first.left);
                valueStack.push(value - first.left.val);
            }
        }
        return false;
    }
}
