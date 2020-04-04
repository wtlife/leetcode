package code.tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();

            TreeNode temp = first.left;
            first.left = first.right;
            first.right = temp;

            if (first.left!=null){
                queue.add(first.left);
            }
            if (first.right!=null){
                queue.add(first.right);
            }
        }
        return root;
    }

}
