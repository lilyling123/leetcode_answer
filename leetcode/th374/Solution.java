package th374;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int guessNumber(int num) {
        if (num == 1 || num == 0)
            return num;
        int hi = 1;
        int lo = 1;
        while (true) {
            long res = (long) hi * hi;
            if (res > num)
                break;
            lo = hi;
            hi <<= 1;
            if (hi * hi == num)
                return hi;
        }
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long res = (long) mid * mid;
            if (res < num) {
                lo = mid + 1;
            } else if (res > num) {
                hi = mid - 1;
            } else
                return mid;
        }

        return lo-1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().guessNumber(2));
    }
}