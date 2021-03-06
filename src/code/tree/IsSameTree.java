package code.tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Desc 100. IsSameTree
 * @date   2020/7/30
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null){
            return true;
        }
        if (p==null || q==null){
            return false;
        }
        return p.val==q.val &&  isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (!isSame(p, q)) {
            return false;
        }
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueP.add(p);
        queueQ.add(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode tempP = queueP.poll();
            TreeNode tempQ = queueQ.poll();
            if (!isSame(tempP, tempQ)) {
                return false;
            }

            if (!isSame(tempP.left, tempQ.left)) {
                return false;
            }
            if (tempP.left != null) {
                queueP.add(tempP.left);
                queueQ.add(tempQ.left);
            }

            if (!isSame(tempP.right, tempQ.right)) {
                return false;
            }
            if (tempP.right != null) {
                queueP.add(tempP.right);
                queueQ.add(tempQ.right);
            }

        }
        return true;
    }


    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return true;
    }
}
