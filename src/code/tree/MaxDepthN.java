package code.tree;

import entity.Node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 559. N叉树的最大深度
 */
public class MaxDepthN {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children.size() == 0) {
            return 1;
        }

        List<Integer> heights = new LinkedList<>();
        for (Node node : root.children) {
            heights.add(maxDepth(node));
        }
        return Collections.max(heights) + 1;
    }
}
