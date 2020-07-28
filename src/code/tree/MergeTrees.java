package code.tree;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 617.MergeTrees
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return t1;
        }
        if (t1 == null) {
            return t2;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.add(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] arr = stack.pop();

            TreeNode first = arr[0];
            TreeNode second = arr[1];
            if (first == null || second == null) {
                continue;
            }
            first.val += second.val;
            if (first.left == null) {
                first.left = second.left;
            } else {
                stack.push(new TreeNode[]{first.left, second.left});
            }
            if (first.right == null) {
                first.right = second.right;
            } else {
                stack.push(new TreeNode[]{first.right, second.right});
            }

        }
        return t1;

    }

}
