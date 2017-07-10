package th39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);

        combinationSum(candidates, target, new ArrayList(), 0);

        return result;
    }

    private void combinationSum(int[] candidates, int target, List list, int lo) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            int remain = target - candidates[i];

            if (i < lo || remain < 0) {
                continue;
            }

            list.add(candidates[i]);

            combinationSum(candidates, remain, list, i);

            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(new Solution().combinationSum(new int[]{2, 3, 5}, 8));
    }
}