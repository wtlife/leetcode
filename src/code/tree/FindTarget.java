package code.tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindTarget {
    private List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        inOrder(root);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int left = list.get(i);
            int right = list.get(j);
            int sum = left + right;
            if (sum == k) {
                return true;
            }
            if (sum > k) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

}
