package code.tree;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {

    int preOrderIndex = 0;
    int[] inorder;
    int[] preorder;
    private Map<Integer, Integer> inorderIndexMap;

    /**
     * preorder : 根左右
     * inorder: 左根右
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;

        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        int idx = 0;
        for (int val : inorder) {
            inorderIndexMap.put(val, idx++);
        }
        this.inorderIndexMap = inorderIndexMap;

        TreeNode res = helper(0, inorder.length);
        preOrderIndex = 0;
        return res;
    }

    private TreeNode helper(int start, int end) {
        if (start == end) {
            return null;
        }

        int nodeVal = preorder[preOrderIndex];
        TreeNode node = new TreeNode(nodeVal);
        preOrderIndex++;

        int inOrderIndex = inorderIndexMap.get(nodeVal);

        node.left = helper(start, inOrderIndex);
        node.right = helper(inOrderIndex + 1, end);


        return node;
    }
    public TreeNode buildTrees(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

}
