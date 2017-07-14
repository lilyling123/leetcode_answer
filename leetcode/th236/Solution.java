package th236;

import Utils.TreeNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left != null ? (right != null ? root : left) : right;


    }
}