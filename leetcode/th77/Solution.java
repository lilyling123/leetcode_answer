package th77;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {

        result = new ArrayList<>();
        if (n == 0 || k > n)
            return result;

        combine(n, 1, k, new ArrayList<>());

        return result;
    }

    private void combine(int n, int start, int k, List es) {
        if (es.size() == k) {
            result.add(new ArrayList<>(es));
            return;
        }
        //还有k-es.size()个空位
        for (int i = start; i <= n - k + es.size() + 1; i++) {
            es.add(i);

            combine(n, i + 1, k, es);

            es.remove(es.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}