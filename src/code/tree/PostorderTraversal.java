package code.tree;

import entity.TreeNode;

import java.util.*;

public class PostorderTraversal {

    /**
     * 正经做法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null && !set.contains(cur)) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            //右子树为空或者第二次来到这里
            if (cur.right == null || set.contains(cur)) {
                res.add(cur.val);
                set.add(cur);
                stack.pop();//将当前节点弹出

                //转到右子树，这种情况对应于右子树为空的情况
                cur = stack.peek();
                cur = cur.right;
                //从左子树过来，加到 set 中，转到右子树
            } else {
                set.add(cur);
                cur = cur.right;
            }
        }
        return res;
    }

    /**
     * 前序遍历 根左右
     * 这里改为 根右左，结果数组采用头插法
     * 输出为 左右根，取巧做法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode first = stack.pop();
            res.addFirst(first.val);
            if (first.left != null) {
                stack.push(first.left);
            }
            if (first.right != null) {
                stack.push(first.right);
            }
        }
        return res;
    }

    /**
     * 递归做法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

}
