package java130;

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] v = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            spread(board, v, i, 0);
            spread(board, v, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            spread(board, v, 0, i);
            spread(board, v, m - 1, i);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (!v[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
    }

    public void spread(char[][] board, boolean[][] v, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n)
            return;
        if (v[x][y] || board[x][y] == 'X')
            return;
        v[x][y] = true;
        spread(board, v, x - 1, y);
        spread(board, v, x, y - 1);
        spread(board, v, x + 1, y);
        spread(board, v, x, y + 1);
    }
}