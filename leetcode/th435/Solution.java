package th435;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end > o2.end ? 1 : o1.end == o2.end ? 0 : -1;
            }
        });
        int res = 0;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (end <= intervals[i].start) {
                res++;
                end = intervals[i].end;
            }

        }

        return intervals.length - res;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] ins = new int[100];
        for (int i = 0; i < ins.length; i++) {
            ins[i] = r.nextInt(100);
        }

        mergeSort(ins);

        System.out.println(Arrays.toString(ins));

    }

    private static int[] array;

    public static void mergeSort(int[] nums) {
        array = new int[nums.length];

        mergeSort(nums, 0, nums.length - 1);
    }

    //hi可达
    public static void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);

        merge(nums, lo, mid, hi);


    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            array[k] = nums[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid)
                nums[k] = array[j++];
            else if (j > high)
                nums[k] = array[i++];
            else if (array[j] < array[i])
                nums[k] = array[j++];
            else
                nums[k] = array[i++];

        }

    }
}

