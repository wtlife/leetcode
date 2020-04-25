package code.tree;

import entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 993. 二叉树的堂兄弟节点
 */
public class IsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int dep = 0;
        Map<Integer, Integer> depMap = new HashMap<>();
        Map<Integer, Integer> paretnMap = new HashMap<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode first = queue.poll();
                if (first.right != null) {
                    queue.offer(first.right);
                    paretnMap.put(first.right.val, first.val);
                }
                if (first.left != null) {
                    queue.offer(first.left);
                    paretnMap.put(first.left.val, first.val);
                }
                if (first.val == x || first.val == y) {
                    depMap.put(first.val, dep);
                }
            }
            dep++;
        }
        return depMap.get(x).equals(depMap.get(y)) && !paretnMap.get(x).equals(paretnMap.get(y));
    }
}
