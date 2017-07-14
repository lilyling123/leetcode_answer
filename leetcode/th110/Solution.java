package th110;

import Utils.TreeNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (right - left > 1 || left - right > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


}