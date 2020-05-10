package code.tree;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
}
