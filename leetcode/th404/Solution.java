package th404;

import Utils.TreeNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null) {
            return sumOfLeftLeaves(root.right);
        }
        if (root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);
        else
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}