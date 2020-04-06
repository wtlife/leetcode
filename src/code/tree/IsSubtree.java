package code.tree;

import entity.TreeNode;

public class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (isEqual(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isEqual(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }


//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        return s != null && (equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
//    }
//
//
//    // 比较两棵树是否相等
//    private boolean equals(TreeNode t1, TreeNode t2) {
//        if (t1 == null && t2 == null) return true;
//        else if (t1 == null || t2 == null) return false;
//
//        return t1.val == t2.val && equals(t1.left, t2.left) && equals(t1.right, t2.right);
//    }

}
