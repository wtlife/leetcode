package code.daybyday.may;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {
    private int[] preorder;
    private int[] inorder;
    private Map<Integer, Integer> inorderIndexMap;
    int preOrderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        this.inorderIndexMap = inorderIndexMap;

        TreeNode node = helper(0, inorder.length );
        preOrderIndex=0;
        return node;
    }

    private TreeNode helper(int left, int right) {
        if (left == right) {
            return null;
        }

        int nodeVal= preorder[preOrderIndex];
        TreeNode node = new TreeNode(nodeVal);
        preOrderIndex++;

        Integer inorderIndex = inorderIndexMap.get(nodeVal);

        node.left = helper(left, inorderIndex);
        node.right = helper(inorderIndex + 1, right);

        return node;
    }
}
