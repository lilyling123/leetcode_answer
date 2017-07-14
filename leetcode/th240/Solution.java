package th240;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = 0;
        if (matrix.length == 0)
            return false;

        int n = matrix[0].length - 1;

        while (target >= matrix[m][n])
            m++;
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[m][mid] < target) {
                lo = mid + 1;
            } else if (matrix[m][mid] > target) {
                hi = mid;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                {}}, 23));
    }
}