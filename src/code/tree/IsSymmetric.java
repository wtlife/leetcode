package code.tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一个树是否镜像对称
 */
public class IsSymmetric {
    //递归
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean valSame = p.val == q.val;
        boolean leftSame = isMirror(p.left, q.right);
        boolean rightSame = isMirror(p.right, q.left);
        return valSame && leftSame && rightSame;
    }

    //迭代
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            queue.add(p.left);
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);
        }
        return true;
    }
}
