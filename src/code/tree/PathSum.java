package code.tree;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, map, sum, 0);
    }

    private int helper(TreeNode root, Map<Integer, Integer> map, int sum, int pathSum) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        pathSum += root.val;
        res += map.getOrDefault(pathSum - sum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);

        res += helper(root.left, map, sum, pathSum);
        res += helper(root.right, map, sum, pathSum);

        map.put(pathSum, map.get(pathSum) - 1);
        return res;
    }
}
