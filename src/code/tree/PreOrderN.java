package code.tree;

import entity.Node;

import java.util.LinkedList;
import java.util.List;

public class PreOrderN {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root != null) {
            res.add(root.val);
            for (Node node : root.children) {
                res.addAll(preorder(node));
            }
        }
        return res;
    }
}
