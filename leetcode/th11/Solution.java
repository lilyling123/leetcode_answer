package th11;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int maxArea(int[] height) {

        int maxarea = Integer.MIN_VALUE;
        int i = 0, j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                int pivot = height[i];
                maxarea = max(pivot * (j - i), maxarea);
                while (i < j && height[i] <= pivot) {
                    i++;
                }
            } else {
                int pivot = height[j];
                maxarea = max(pivot * (j - i), maxarea);
                while (i < j && height[j] <= pivot) {
                    j--;
                }
            }
        }

        return maxarea;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}