package th79;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private int[][] tran = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean[][] visited;

    private boolean inArea(int X, int Y, char[][] board) {
        if (X < 0 || Y < 0)
            return false;
        if (X >= board.length || Y >= board[0].length) {
            return false;
        }
        return true;

    }


    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, i, j, words, 0))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] words, int k) {

        if (words[k] == board[i][j]) {
            if (k == words.length - 1) {
                return true;
            }


            for (int n = 0; n < tran.length; n++) {
                int newX = i + tran[n][0];
                int newY = j + tran[n][1];
                visited[i][j] = true;

                if (inArea(newX, newY, board) &&
                        !visited[newX][newY] &&
                        dfs(board, newX, newY, words, k + 1))
                    return true;

                visited[i][j] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
        System.out.println(new Solution().exist(new char[][]{
                {'a'}
        }, "a"));

    }
}