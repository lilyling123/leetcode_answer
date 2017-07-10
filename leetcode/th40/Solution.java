package th40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private List<List<Integer>> result;


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();

        combinationSum2(candidates, target, new ArrayList(), 0);

        return result;
    }

    private void combinationSum2(int[] candidates, int target, List es, int lo) {
        if (target == 0) {
            result.add(new ArrayList(es));
            return;
        } else {
            for (int i = lo; i < candidates.length; i++) {
                if ((i > lo && candidates[i] == candidates[i - 1]) ||
                        target < candidates[i])
                    continue;
                es.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], es, i + 1);
                es.remove(es.size() - 1);

            }
        }
    }

    public static void main(String[] args) {

        System.out.println(new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}