package th441;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int arrangeCoins(int n) {
        long res = 1;

        int count = 1;
        while (res < n) {
            count++;
            res =  res + count;
        }
        if (res == n)
            return count;
        return count - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().arrangeCoins(2147483647));
    }
}