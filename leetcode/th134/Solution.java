package th134;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            queue = bfs(queue, res);
        }
        return res;
    }

    private LinkedList<TreeNode> bfs(LinkedList<TreeNode> queue, LinkedList<Integer> res) {
        LinkedList<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.addLast(node.val);
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        res.add(list.getLast());
        return q;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(new Solution().rightSideView(root));
    }
}