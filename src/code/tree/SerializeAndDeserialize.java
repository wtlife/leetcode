package code.tree;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化
 */
public class SerializeAndDeserialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
            } else {
                queue.add(node.left);
                queue.add(node.right);
                sb.append(node.val).append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1).append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 2) {
            return null;
        }
        //split /inclusive,exclusive
        String[] strings = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(strings[i])) {
                node.left = new TreeNode(Integer.parseInt(strings[i]));
                queue.offer(node.left);
            }
            i++;

            if (!"null".equals(strings[i])) {
                node.right = new TreeNode(Integer.parseInt(strings[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
