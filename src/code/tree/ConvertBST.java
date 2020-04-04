package code.tree;

import entity.TreeNode;

import java.util.Stack;

public class ConvertBST {

    private int sum = 0;
    private int sum2 = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);

            sum += root.val;
            root.val = sum;

            convertBST(root.left);
        }
        return root;
    }

    public TreeNode convertBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            node = node.left;
        }

        return root;
    }
}
