package th145;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private static class Command {
        String command;
        TreeNode node;

        public Command(String commond, TreeNode node) {
            this.command = commond;
            this.node = node;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));

        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (command.command == "add") {
                res.add(command.node.val);
            } else {
                stack.push(new Command("add", command.node));
                if (command.node.right != null) {
                    stack.push(new Command("go", command.node.right));
                }
                if (command.node.left != null) {
                    stack.push(new Command("go", command.node.left));
                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new Solution().postorderTraversal(root));
    }
}