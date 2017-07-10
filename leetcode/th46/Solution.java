package th46;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private List<List<Integer>> result;
    private boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        visited = new boolean[nums.length];
        permute(nums, new ArrayList<>());

        return result;
    }

    private void permute(int[] nums, List<Integer> res) {

        if (res.size() == nums.length) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res.add(nums[i]);

                permute(nums, res);

                visited[i] = false;
                res.remove(res.size() - 1);


            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }
}