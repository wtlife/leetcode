package code.stack;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Desc 173.BSTIterator
 * @date 2020/8/5
 */
public class BSTIterator {
    Deque<Integer> minStack;
    public BSTIterator(TreeNode root) {
        this.minStack = new ArrayDeque<>();
        backTrack(root);
    }

    private void backTrack(TreeNode root) {
        if (root==null) {
            return;
        }
        backTrack(root.right);
        minStack.addLast(root.val);
        backTrack(root.left);
    }


    /** @return the next smallest number */
    public int next() {
        return minStack.pollLast();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !minStack.isEmpty();
    }
}
