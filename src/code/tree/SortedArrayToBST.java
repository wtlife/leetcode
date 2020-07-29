package code.tree;

import entity.TreeNode;


/**
 * @Desc 108. sortedArrayToBST
 * @date 2020/7/29
 */
public class SortedArrayToBST {
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    private TreeNode helper(int l, int r) {
        if (l > r) {
            return null;
        }
        int p = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(l, p - 1);
        root.right = helper(p + 1, r);
        return root;
    }
}
