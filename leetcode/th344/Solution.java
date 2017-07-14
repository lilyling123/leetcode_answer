package th344;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public String reverseString(String s) {
        char[] chars = new char[s.length()];
        int hi = chars.length - 1;
        int i = 0;
        while (hi >= 0) {
            chars[i++] = s.charAt(hi);
            hi--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseString("hello"));
    }
}