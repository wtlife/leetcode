package code.tree;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<String> pathQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        pathQueue.add(String.valueOf(root.val));
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                String path = pathQueue.poll();
                if (node.left == null && node.right == null) {
                    res.add(path);
                }
                if (node.left != null) {
                    String leftPath = path+"->"+node.left.val;
                    nodeQueue.add(node.left);
                    pathQueue.add(leftPath);
                }
                if (node.right!= null) {
                    String rightPath = path+"->"+node.right.val;
                    nodeQueue.add(node.right);
                    pathQueue.add(rightPath);
                }
            }
        }
        return res;
    }
}
