package th216;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();

        combinationSum3(k, n, 1, new ArrayList());

        return result;
    }

    private void combinationSum3(int k, int n, int i, List list) {
        if (n == 0 && list.size() == k) {
            result.add(new ArrayList(list));
        }

        for (int j = i; j <= 9; j++) {
            n = n - j;
            list.add(j);

            combinationSum3(k, n, j + 1, list);

            list.remove(list.size() - 1);
            n = n + j;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3,18));
    }
}