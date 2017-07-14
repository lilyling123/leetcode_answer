package th202;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean isHappy2(int n) {
        while (n > 6) {
            int next = 0;
            while (n > 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }
            n = next;
            System.out.println(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        new Solution().isHappy2(25);
    }

    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<>();

        int squareSum, remain;

        while (inLoop.add(n)) {

            squareSum = 0;

            while (n > 0) {

                remain = n % 10;

                squareSum += remain * remain;

                n /= 10;

            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;
        }
        return false;
    }
}