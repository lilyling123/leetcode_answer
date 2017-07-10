package th7;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public long reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
    }
}