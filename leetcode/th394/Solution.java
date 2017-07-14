package th394;

import java.util.Stack;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {

    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {

                resStack.push(res);

                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                int count = countStack.pop();
                StringBuilder sb = new StringBuilder(resStack.pop());

                while (count-- > 0) {
                    sb.append(res);
                }

                res = sb.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
    }
}