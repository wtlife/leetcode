package code.tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc 173.BSTIterator
 * @date 2020/7/28
 */
public class BSTIterator {

    private LinkedList<Integer> vals;

    public BSTIterator(TreeNode root) {
        this.vals = new LinkedList<>();
        traverse(root);
    }

    //中序遍历
    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        vals.add(root.val);
        traverse(root.right);
    }


    /**
     * @return the next smallest number
     */
    public int next() {
        return vals.pollFirst();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !vals.isEmpty();
    }
}
