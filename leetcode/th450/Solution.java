package th450;

import Utils.TreeNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);

        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);

        } else {
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            TreeNode target = root.right;
            while (target.left != null) {
                target = target.left;
            }
            root.val = target.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }


}