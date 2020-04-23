package code.tree;

import entity.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 */
public class PostOrderN {
    List<Integer> res;
    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    //后序 左右根
    private void helper(Node root) {
        if (root==null){
            return;
        }
        for (Node node:root.children) {
            helper(node);
        }

        res.add(root.val);
    }
}
