package th20;

import java.util.Stack;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        int[] symbol = new int[256];
        symbol['['] = 3;
        symbol['{'] = 2;
        symbol['('] = 1;

        symbol[']'] = -3;
        symbol['}'] = -2;
        symbol[')'] = -1;

        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (symbol[chars[i]] > 0) {
                stack.push(chars[i]);
            } else {
                if (sum != 0 || stack.isEmpty()) {
                    return false;
                }
                sum = symbol[stack.pop()] + symbol[chars[i]];
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("[(){]}"));
    }
}