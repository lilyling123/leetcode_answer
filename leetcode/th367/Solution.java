package th367;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        int hi = 1;
        int lo = 1;
        while (true) {
            long res = (long) hi * hi;
            if (res > num)
                break;
            lo = hi;
            hi <<= 1;
            if (hi * hi == num)
                return true;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long res = (long) mid * mid;
            if (res < num) {
                lo = mid + 1;
            } else if (res > num) {
                hi = mid - 1;
            } else
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(2147483647));
    }
}