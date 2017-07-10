package th71;

import java.util.Stack;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals(".")) {

            } else if (paths[i].equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!paths[i].equals("")) {
                stack.push(paths[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        if (sb.length() == 0)
            return "/";
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/.."));
    }
}