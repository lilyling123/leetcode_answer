package th200;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private boolean[][] visited;
    private int[][] tran = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean inArea(int X, int Y, char[][] board) {
        if (X < 0 || Y < 0)
            return false;
        if (X >= board.length || Y >= board[0].length) {
            return false;
        }
        return true;
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid.length == 0) {
            return res;
        }
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int X, int Y) {
        if (visited[X][Y]) {
            return;
        }
        if (!visited[X][Y]) {
            visited[X][Y] = true;
            for (int i = 0; i < tran.length; i++) {
                int newX = X + tran[i][0];
                int newY = Y + tran[i][1];

                if (inArea(newX, newY, grid)
                        && !visited[newX][newY]
                        && grid[newX][newY] == '1') {
                    dfs(grid, newX, newY);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }
}