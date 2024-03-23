from typing import List


class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        m, n = len(matrix), len(matrix[0])
        mark_row, mark_col = 0, 0
        row0 = False
        for i in range(n):
            if matrix[0][i] == 0:
                row0 = True
        col0 = False
        for i in range(m):
            if matrix[i][0] == 0:
                col0 = True
        if row0 and col0:
            mark_row, mark_col = 1, 1
            for i in range(m):
                if matrix[i][0] == 0:
                    matrix[i][0] = 1
                else:
                    matrix[i][0] = 0
            for i in range(1, n):
                if matrix[0][i] == 0:
                    matrix[0][i] = 1
                else:
                    matrix[0][i] = 0
        elif row0:
            mark_row = 1
            for i in range(n):
                if matrix[0][i] == 0:
                    matrix[0][i] = 1
                else:
                    matrix[0][i] = 0
        elif col0:
            mark_col = 1
            for i in range(m):
                if matrix[i][0] == 0:
                    matrix[i][0] = 1
                else:
                    matrix[i][0] = 0
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j] == 0:
                    matrix[i][0] = mark_col
                    matrix[0][j] = mark_row
        for i in range(1, m):
            if matrix[i][0] == mark_col:
                for j in range(n):
                    matrix[i][j] = 0
        for j in range(1, n):
            if matrix[0][j] == mark_row:
                for i in range(m):
                    matrix[i][j] = 0
        if matrix[0][0] == 1 and mark_col * mark_row == 1:
            for i in range(m):
                matrix[i][0] = 0
            for j in range(1, n):
                matrix[0][j] = 0
