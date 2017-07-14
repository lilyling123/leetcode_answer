package th376;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int k = 0;
        while (k < nums.length - 1 && nums[k] == nums[k + 1]) {
            k++;
        }
        if (k == nums.length - 1) {
            return 1;
        }
        int result = 2;
        boolean smallReq = nums[k] < nums[k + 1];
        for (int i = k + 1; i < nums.length - 1; i++) {
            if (smallReq && nums[i] > nums[i + 1]) {

                nums[result] = nums[i + 1];
                result++;
                smallReq = !smallReq;
            } else if (!smallReq && nums[i] < nums[i + 1]) {

                nums[result] = nums[i + 1];
                result++;
                smallReq = !smallReq;
            }


        }
        return result;
    }
}