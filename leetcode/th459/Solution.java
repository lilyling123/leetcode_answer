package th459;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int i = 1;
        while (i <= n / 2) {
            if (n % i == 0) {
                String str = s.substring(0, i);
                int j = n;
                while (j >= i) {
                    if (!str.equals(s.substring(j - i, j)))
                        break;
                    j -= i;
                }
                if (0 == j) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("abab"));
    }
}