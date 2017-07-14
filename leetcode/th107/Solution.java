package th107;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);

                list.add(queue.poll().val);
            }
            res.addFirst(list);

        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            queue = bfs(queue, res);
        }
        return res;
    }

    private LinkedList<TreeNode> bfs(LinkedList<TreeNode> queue, LinkedList<List<Integer>> res) {
        LinkedList<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        res.addFirst(list);
        return q;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().levelOrderBottom2(root));
    }
}