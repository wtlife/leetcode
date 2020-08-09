package code.stack;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Desc 103.ZigzagLevelOrder
 * @date 2020/8/6
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.addLast(root);
        int c = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            if (c % 2 == 0) {
                int size = stack1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode first = stack1.pollLast();
                    tmp.add(first.val);
                    if (first.left != null) {
                        stack2.addLast(first.left);
                    }
                    if (first.right != null) {
                        stack2.addLast(first.right);
                    }

                }
            } else {
                int size = stack2.size();
                for (int i = 0; i < size; i++) {
                    TreeNode first = stack2.pollLast();
                    tmp.add(first.val);
                    if (first.right != null) {
                        stack1.addLast(first.right);
                    }
                    if (first.left != null) {
                        stack1.addLast(first.left);
                    }

                }
            }
            res.add(tmp);
            c++;
        }
        return res;
    }
}
