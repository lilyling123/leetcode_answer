package th557;

/**
 * Created by lily_ling on 2017/6/15.
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 */
public class Solution {
    public String reverseWords(String s) {
        String[] stringArray = s.split(" ");

        for (int i = 0; i < stringArray.length; i++) {
            char[] t = stringArray[i].toCharArray();
            int lo = 0, hi = t.length - 1;
            while (lo < hi) {
                char c = t[lo];
                t[lo++] = t[hi];
                t[hi--] = c;
            }
            stringArray[i] = new String(t);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            if (i != stringArray.length - 1) {
                sb.append(stringArray[i]);
                sb.append(" ");
            } else {
                sb.append(stringArray[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
}