package th606;

import Utils.TreeNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public String tree2str(TreeNode t) {

        if (t == null)
            return "";
        return tree2str(t, new StringBuilder());
    }

    private String tree2str(TreeNode t, StringBuilder sb) {
        sb.append(t.val);
        if (t.left == null && t.right == null) {
            return sb.toString();
        }

        if (t.left == null) {
            sb.append("()");
        } else {
            sb.append("(");
            sb.append(tree2str(t.left, new StringBuilder()));
            sb.append(")");
        }

        if (t.right != null) {
            sb.append("(");
            sb.append(tree2str(t.right, new StringBuilder()));
            sb.append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.left.left = new TreeNode(4);
        System.out.println(new Solution().tree2str(t));
    }
}