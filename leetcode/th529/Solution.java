package th529;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    int[][] trans = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0},
            {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    private boolean inArea(int X, int Y, char[][] board) {
        return X >= 0 && Y >= 0 && X < board.length && Y < board[0].length;
    }

    public char[][] updateBoard1(char[][] board, int[] click) {
        int X = click[0];
        int Y = click[1];

        if (board[X][Y] == 'M') {
            board[X][Y] = 'X';
            return board;
        }
        int mineCount = 0;
        for (int[] tran : trans) {
            int newX = X + tran[0];
            int newY = Y + tran[1];
            if (inArea(newX, newY, board)) {
                if (board[newX][newY] == 'M') {
                    mineCount++;
                }
            }
        }
        if (mineCount > 0) {
            board[X][Y] = (char) (mineCount + '0');
            return board;
        }
        board[X][Y] = 'B';

        for (int[] tran : trans) {
            int newX = X + tran[0];
            int newY = Y + tran[1];
            if (inArea(newX, newY, board)) {
                if (board[newX][newY] == 'E') {
                    updateBoard(board, new int[]{newX, newY});
                }
            }
        }
        return board;
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];

        if (board[row][col] == 'M') { // Mine
            board[row][col] = 'X';
        } else { // Empty
            // Get number of mines first.
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    int r = row + i, c = col + j;
                    if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                    if (board[r][c] == 'M' || board[r][c] == 'X') count++;
                }
            }

            if (count > 0) { // If it is not a 'B', stop further DFS.
                board[row][col] = (char) (count + '0');
            } else { // Continue DFS to adjacent cells.
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                        if (board[r][c] == 'E') updateBoard(board, new int[]{r, c});
                    }
                }
            }
        }

        return board;
    }

    public static void main(String[] args) {
        char[][] chars = new Solution().updateBoard1(new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        }, new int[]{0, 0});
        System.out.println();
    }
}