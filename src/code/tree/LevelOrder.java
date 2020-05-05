package code.tree;

import entity.TreeNode;

import java.util.*;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i <size ; i++) {
                TreeNode node = queue.poll();
                if (node!=null){
                    tempList.add(node.val);

                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (tempList.size()>0){
                res.add(tempList);
            }
        }
        return res;
    }
}
