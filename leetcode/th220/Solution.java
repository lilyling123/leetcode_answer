package th220;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;

            long bucket = remappedNum / ((long) t + 1);

            //计算出满足条件的情况，若存在则返回
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;

            //保持窗口大小为k
            if (map.entrySet().size() >= k) {

                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);

                map.remove(lastBucket);

            }
            map.put(bucket, remappedNum);
        }

        return false;

    }
}