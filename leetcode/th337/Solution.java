package th337;

import Utils.TreeNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        return Math.max(robInclude(root), robExclude(root));
    }

    private int robExclude(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return rob(root.left) + rob(root.right);
    }

    private int robInclude(TreeNode root) {
        if (root == null)
            return 0;
        return robExclude(root.left) + robExclude(root.right) + root.val;
    }

    public int rob2(TreeNode root) {
        int[] res = robHelper(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robHelper(TreeNode node) {
        if(node == null) {
            return new int[2];
        }
        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); //Current node is not robbed, so left and right can be robbed, find out what gives max value
        res[1] = node.val + left[0] + right[0]; //Current node is robbed, so left and right cannot be robbed, use the first elements of both and add current value

        return res;
    }
}