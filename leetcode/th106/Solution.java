package th106;

import Utils.TreeNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || inorder.length != postorder.length)
            return null;

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

    }

    public TreeNode buildTree(int[] inorder, int L1, int H1, int[] postorder, int L2, int H2) {
        if (L1 == H1)
            return new TreeNode(inorder[L1]);
        if (L1 > H1 || L2 > H2) {
            return null;
        }

        int val = postorder[H2];

        TreeNode root = new TreeNode(val);

        int M1 = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                M1 = i;
                break;
            }
        }
        root.left = buildTree(inorder, L1, M1 - 1, postorder, L2, L2 + M1 - 1 - L1);
        root.right = buildTree(inorder, M1 + 1, H1, postorder, H2 - H1 + M1, H2 - 1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new Solution().buildTree(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 2, 1});
        System.out.println(node.val);
        System.out.println(node.right.val);
    }
}