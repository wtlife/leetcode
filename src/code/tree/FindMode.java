package code.tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class FindMode {

    private TreeNode pre;
    private int thisTimes = 0;
    private int maxTimes = 0;
    private List<Integer> resList = new LinkedList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int size = resList.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);

        if (pre != null && pre.val == root.val) {
            thisTimes++;
        } else {
            thisTimes = 1;
        }
        if (thisTimes == maxTimes) {
            resList.add(root.val);
        } else if (thisTimes > maxTimes) {
            maxTimes = thisTimes;
            resList.clear();
            resList.add(root.val);
        }


        pre = root;
        inOrder(root.right);
    }
}
