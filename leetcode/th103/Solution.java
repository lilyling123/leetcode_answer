package th103;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            queue = bfs(queue, res, flag);
            flag = !flag;
        }
        return res;
    }

    private LinkedList<TreeNode> bfs(LinkedList<TreeNode> queue, LinkedList<List<Integer>> res, boolean flag) {
        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (flag)
                list.addLast(node.val);
            else
                list.addFirst(node.val);
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        res.add(list);
        return q;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().zigzagLevelOrder(root));
    }
}