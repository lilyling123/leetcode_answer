package th125;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        new Solution().isPalindrome("A man, a plan, a canal: Panama");
    }
}