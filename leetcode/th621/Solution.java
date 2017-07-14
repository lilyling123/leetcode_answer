package th621;

import java.util.Arrays;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for (char t : tasks) {
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while (i >= 0 && c[i] == c[25]) i--;


        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);


    }

    public static void main(String[] args) {

        System.out.println(new Solution().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}