package th117;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode lever_Node = root;
        while (lever_Node != null) {
            TreeLinkNode cur = lever_Node;
            while (cur != null) {
                if (cur.left != null) {


                }


                cur = cur.next;
            }
            lever_Node = lever_Node.left;
        }

    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}