package th47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    List<List<Integer>> result;
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUnique(nums, new ArrayList<>());


        return result;
    }

    private void permuteUnique(int[] nums, List es) {

        if (es.size() == nums.length) {
            result.add(new ArrayList<>(es));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i - 1] == nums[i] && visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                es.add(nums[i]);

                permuteUnique(nums, es);

                visited[i] = false;
                es.remove(es.size() - 1);

            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1, 1, 2}));
    }
}