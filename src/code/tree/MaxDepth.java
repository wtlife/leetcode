package code.tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. MaxDepth
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int dep = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dep++;
            for (int i = 0; i < size; i++) {
                TreeNode first = queue.poll();

                if (first.left != null) {
                    queue.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                }
            }
        }
        return dep;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);
        return Math.max(left, right) + 1;
    }

}
