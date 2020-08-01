package code.tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 95.GenerateTrees
 * @date 2020/7/31
 */
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>res = helper(1, n);
        return res;
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int j = start; j <= end; j++) {

            List<TreeNode> leftTrees = helper(start, j-1);
            List<TreeNode> rightTrees = helper(j + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(j);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
