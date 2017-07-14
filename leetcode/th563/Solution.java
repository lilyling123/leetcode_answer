package th563;

import Utils.TreeNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    int res = 0;
    public int findTilt(TreeNode root) {
        help(root);
        return res;
    }

    private int help(TreeNode root) {
        if (root == null) return 0;
        int left = help(root.left);
        int right = help(root.right);
        res += Math.abs(left - right);
        return left + root.val + right;
    }
}