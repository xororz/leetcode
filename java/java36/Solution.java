package java36;

import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] cols = new Set[9];
        Set<Character>[] blocks = new Set[9];
        int i, j;
        for (i = 0; i < 9; i++) {
            cols[i] = new HashSet<Character>();
            blocks[i] = new HashSet<Character>();
        }
        for (i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<Character>();
            for (j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j]))
                        return false;
                    else
                        row.add(board[i][j]);
                    if (cols[j].contains(board[i][j]))
                        return false;
                    else
                        cols[j].add(board[i][j]);
                    if (blocks[(i / 3) * 3 + j / 3].contains(board[i][j]))
                        return false;
                    else
                        blocks[(i / 3) * 3 + j / 3].add(board[i][j]);
                }
            }
        }
        return true;
    }
}
