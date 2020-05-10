package code.tree;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree2 {

    int[] inorder;
    int[] postorder;
    int postOrderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    /**
     * inorder : 左根右
     * postorder: 左右根
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        postOrderIndex = postorder.length - 1;

        Map<Integer, Integer> inOrderValIndexMap = new HashMap<>();
        int idx = 0;
        for (int val : inorder) {
            inOrderValIndexMap.put(val, idx++);
        }
        this.inorderIndexMap = inOrderValIndexMap;

        TreeNode res = helper(0, inorder.length);
        return res;
    }

    private TreeNode helper(int start, int end) {
        if (start == end) {
            return null;
        }

        int postVal = postorder[postOrderIndex];
        TreeNode node = new TreeNode(postVal);
        postOrderIndex--;

        int inorderIdx = inorderIndexMap.get(postVal);
        node.right = helper(inorderIdx + 1, end);
        node.left = helper(start, inorderIdx);

        return node;
    }
}
