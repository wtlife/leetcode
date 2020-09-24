package code.leetbook.bytedance.nodetree;

import entity.TreeNode;

import java.util.*;

/**
 * @Desc ZigzagLevelOrder
 * @date 2020/9/21
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int carry = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode first = deque.pollFirst();
                if (carry % 2 == 0) {
                    tmp.add(first.val);
                } else {
                    tmp.add(0, first.val);
                }
                if (first.left != null) {
                    deque.addLast(first.left);
                }
                if (first.right != null) {
                    deque.addLast(first.right);
                }
            }
            ans.add(tmp);
            carry++;
        }
        return ans;
    }
}