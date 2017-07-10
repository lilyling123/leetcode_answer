package th70;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }


        return memo[n];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(8));
    }
}