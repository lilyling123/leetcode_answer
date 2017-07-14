package th116;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {

    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start = root;
        while (level_start != null) {
            TreeLinkNode cur = level_start;
            while (cur != null) {
                if (cur.left != null)
                    cur.left.next = cur.right;
                if (cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }

            level_start = level_start.left;
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