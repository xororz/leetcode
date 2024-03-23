package java37;

class Solution {
    public void solveSudoku(char[][] board) {
        boolean row[][] = new boolean[9][9];
        boolean col[][] = new boolean[9][9];
        boolean box[][] = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int k = (i / 3) * 3 + j / 3;
                    row[i][num] = true;
                    col[j][num] = true;
                    box[k][num] = true;
                }
            }
        }
        solve(board, row, col, box, 0, 0);
    }

    public boolean solve(char[][] board, boolean row[][], boolean col[][], boolean box[][], int i, int j) {
        if (i == 9) {
            return true;
        }
        if (j == 9) {
            return solve(board, row, col, box, i + 1, 0);
        }
        if (board[i][j] != '.') {
            return solve(board, row, col, box, i, j + 1);
        }
        for (int num = 0; num < 9; num++) {
            int k = (i / 3) * 3 + j / 3;
            if (!row[i][num] && !col[j][num] && !box[k][num]) {
                row[i][num] = true;
                col[j][num] = true;
                box[k][num] = true;
                board[i][j] = (char) (num + '0' + 1);
                if (solve(board, row, col, box, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
                row[i][num] = false;
                col[j][num] = false;
                box[k][num] = false;
            }
        }
        return false;
    }
}