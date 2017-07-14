package th279;

import java.util.LinkedList;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    //可以用赛马的形式来看
    public int numSquares(int n) {
        LinkedList<int[]> q = new LinkedList<>();

        q.push(new int[]{n, 0});
        boolean[] visit = new boolean[n + 1];
        visit[n] = true;
        while (!q.isEmpty()) {
            int num = q.peek()[0];
            int step = q.peek()[1];
            q.pop();

            for (int i = 1; ; i++) {
                int a = num - i * i;
                if (a < 0)
                    break;
                if (a == 0)
                    return step + 1;

                if (!visit[a]) {
                    q.addLast(new int[]{a, step + 1});
                    visit[a] = true;
                }
            }
        }
        return 0;
    }

    //可以用赛马的形式来看
    public int numSquares2(int n) {

        int[] memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Integer.MAX_VALUE;
        }
        memo[0] = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            for (int j = 1; j * j <= num; j++) {
                memo[i] = Math.min(memo[num - j * j] + 1, memo[i]);

            }

        }
        return memo[n];
    }

    public static void main(String[] args) {

        System.out.println(new Solution().numSquares2(43));
    }
}