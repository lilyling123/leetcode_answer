package th566;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;
        if (n == 0)
            return nums;
        int m = nums[0].length;
        if (m * n < r * c) {
            return nums;
        }
        int[][] res = new int[r][c];

        int row = 0, col = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (col >= res[0].length) {
                    row++;
                    col = 0;
                }
                if (row >= res.length) {
                    break;
                }
                res[row][col++] = nums[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] ints = new Solution().matrixReshape(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 2, 4);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ,");
            }
            System.out.println();
        }
    }
}