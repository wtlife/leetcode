package code.tree;

import entity.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Tree2str {
    public String tree2str(TreeNode t) {
        if (t==null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(t);
        Set<TreeNode> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            TreeNode first = stack.peek();
            if (visited.contains(first)) {
                stack.pop();
                sb.append(")");
            } else {
                visited.add(first);
                sb.append("(").append(first.val);
                if (first.left == null && first.right != null) {
                    sb.append("()");
                }
                if (first.right != null) {
                    stack.push(first.right);
                }
                if (first.left != null) {
                    stack.push(first.left);
                }
            }
        }
        return sb.toString().substring(1,sb.length());
    }
}
