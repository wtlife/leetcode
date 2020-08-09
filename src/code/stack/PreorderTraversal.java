package code.stack;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Desc 144.PreorderTraversal
 * @date 2020/8/6
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode first = stack.pollLast();
            res.add(first.val);
            if (first.right != null) {
                stack.addLast(first.right);
            }
            if (first.left != null) {
                stack.addLast(first.left);
            }
        }
        return res;
    }
}
