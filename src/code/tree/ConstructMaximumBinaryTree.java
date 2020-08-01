package code.tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 654. ConstructMaximumBinaryTree
 * @date 2020/8/1
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (Integer num : nums) {
            list.add(num);
        }
        TreeNode root = recursive(list);
        return root;
    }

    private TreeNode recursive(List<Integer> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        Integer idx = 0;
        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                idx = i;
            }
        }

        TreeNode node = new TreeNode(max);
        node.left =recursive(list.subList(0,idx));
        node.right =recursive(list.subList(idx+1,list.size()));
        return node;
    }
}

