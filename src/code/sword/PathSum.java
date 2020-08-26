package code.sword;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc PathSum
 * @date 2020/8/21
 */
public class PathSum {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        int current = sum;
        LinkedList<Integer> path = new LinkedList<>();
        helper(root,path,sum);
        return res;
    }

    private void helper(TreeNode root, LinkedList<Integer> path, int sum) {
        if (root==null){
            return;
        }
        sum -= root.val;
        path.addLast(root.val);
        if (sum==0 && root.left==null && root.right==null){
            res.add(new ArrayList<>(path));
        }
        if (root.left!=null){
            helper(root.left,path,sum);
        }
        if (root.right!=null){
            helper(root.right,path,sum);
        }
        path.pollLast();
    }
}
