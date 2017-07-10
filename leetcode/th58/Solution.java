package th58;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.equals(""))
            return 0;
        s = s.trim();
        char[] chars = s.toCharArray();

        int res = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ')
                return res;
            else
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("a"));
    }
}