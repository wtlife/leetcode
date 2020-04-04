package code.tree;

import entity.TreeNode;

import java.util.*;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        Stack<List<Integer>> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        queue.add(root);
        List<Integer> f = new ArrayList<>();
        f.add(root.val);
        stack.add(f);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode first = queue.poll();
                if (first.left != null) {
                    queue.add(first.left);
                    temp.add(first.left.val);
                }
                if (first.right != null) {
                    queue.add(first.right);
                    temp.add(first.right.val);
                }
            }
            if (temp.size() > 0) {
                stack.add(temp);
            }
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
