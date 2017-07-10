package th3;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] flag = new int[256];
        int lo = 0;
        int hi = 0;
        int t = 0;
        int res = 0;
        while (hi < chars.length && lo <= hi) {

            if (flag[chars[hi]] == 0 && flag[chars[hi]] != 2) {
                t += 1;
                res = res > t ? res : t;
                flag[chars[hi]] += 1;
                hi++;
            } else {
                t -= 1;
                flag[chars[lo]] -= 1;
                lo++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }
}