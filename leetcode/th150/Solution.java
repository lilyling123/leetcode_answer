package th150;

import java.util.Stack;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {

                res = stack.pop() + stack.pop();
                stack.push(res);

            } else if (tokens[i].equals("-")) {
                int num = stack.pop();
                res = stack.pop() - num;
                stack.push(res);
            } else if (tokens[i].equals("*")) {

                res = stack.pop() * stack.pop();
                stack.push(res);
            } else if (tokens[i].equals("/")) {

                int num = stack.pop();
                res = stack.pop() / num;
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[]{"0", "3", "/"}));
    }
}