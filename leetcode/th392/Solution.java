package th392;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if ("".equals(s))
            return true;
        if ("".equals(s))
            return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int j = 0;
        for (int i = 0; i < tc.length; i++) {
            if (sc[j] == tc[i]) {
                j++;
            }
            if (j == sc.length) {
                return true;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("ace", "abcde"));
    }
}