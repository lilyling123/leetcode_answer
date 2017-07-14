package th111;

import Utils.TreeNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }
        return 1 + Math.min(left, right);
    }
}