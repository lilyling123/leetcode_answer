package th347;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        TreeSet<Map.Entry<Integer, Integer>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() > o2.getValue() ? -1 : 1;
            }
        });
        set.addAll(map.entrySet());
        for (Map.Entry<Integer, Integer> entry : set) {
            res.add(entry.getKey());
            k--;
            if (k == 0)
                break;
        }
        return res;
    }

    //值得研究
    public List<Integer> topKFrequent2(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();

        List<Integer>[] bucket = new List[nums.length + 1];

        Map<Integer, Integer> map = new HashMap<>();

        for (int item : nums) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (bucket[map.get(key)] == null)
                bucket[map.get(key)] = new ArrayList<>();

            bucket[map.get(key)].add(key);
        }

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }
}