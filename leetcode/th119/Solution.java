package th119;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] memo = new int[rowIndex + 1];
        memo[0] = 1;
        int i = 1;
        while (i <= rowIndex) {
            for (int j = i; j > 0; j--) {
                memo[j] = memo[j] + memo[j - 1];
            }
            i++;
        }


        List<Integer> res = new LinkedList<>();
        for (int j : memo) {
            res.add(j);

        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(5));
    }
}