package th632;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        int min;
        int len = Integer.MAX_VALUE;

        for (List<Integer> num : nums) {
            if (num != null && num.size() > 0) {
                Integer c = num.get(0);
                max = Math.max(max, c);
                queue.add(c);
                if (map.containsKey(c))
                    map.get(c).add(num);
                else {
                    List<List<Integer>> t = new ArrayList<>();
                    t.add(num);
                    map.put(c, t);
                }
            }

        }


        while (true) {
            if (queue.size() < nums.size())
                break;
            min = queue.peek();

            if (max - min < len) {
                res = new int[]{min, max};
                len = max - min;
            }

            Integer poll = queue.poll();
            if (queue.peek() == poll)
                queue.poll();

            if (map.containsKey(poll)) {

                List<List<Integer>> lists = map.get(poll);
                map.remove(poll);

                for (List<Integer> list : lists) {
                    if (list != null && list.size() > 0) {
                        list.remove(0);
                        if (list.size() > 0) {
                            queue.add(list.get(0));
                            max = Math.max(max, list.get(0));
                            if (map.containsKey(list.get(0))) {
                                map.get(list.get(0)).add(list);

                            } else {
                                List<List<Integer>> t = new ArrayList<>();
                                t.add(list);
                                map.put(list.get(0), t);
                            }
                        }
                    }
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {

        List<List<Integer>> nums = new ArrayList<>();

        Integer[][] ins = new Integer[][]{
                {4, 10, 15, 24, 26}, {0, 9, 12, 20}, {5, 18, 22, 30}
        };
        for (Integer[] in : ins) {
            nums.add(new ArrayList<>(Arrays.asList(in)));

        }

        int[] ints = new Solution().smallestRange(nums);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
