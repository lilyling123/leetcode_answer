package th9;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String s = String.valueOf(x);
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--))
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(323));
    }
}