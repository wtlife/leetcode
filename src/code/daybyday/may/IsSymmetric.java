package code.daybyday.may;

import entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode first1 = queue.poll();
            TreeNode first2 = queue.poll();
            if (first1 == null && first2 == null) {
                continue;
            }
            if (first1 == null || first2 == null) {
                return false;
            }
            if (first1.val != first2.val) {
                return false;
            }
            queue.add(first1.left);
            queue.add(first2.right);
            queue.add(first1.right);
            queue.add(first2.left);
        }
        return true;
    }


}
