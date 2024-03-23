class Solution(object):
    def modifiedMatrix(self, matrix):
        m, n = len(matrix), len(matrix[0])
        maxval = [-2 for i in range(n)]
        for j in range(n):
            for i in range(m):
                maxval[j] = max(maxval[j], matrix[i][j])
            for i in range(m):
                if matrix[i][j] == -1:
                    matrix[i][j] = maxval[j]
        return matrix


Solution().modifiedMatrix(
    [
        [3, 1, 1, -1, 1, 2],
        [-1, 3, 1, 0, 1, 3],
        [-1, 2, 3, 0, 3, 1],
        [-1, 0, -1, -1, -1, 1],
        [1, 1, 3, 3, -1, 0],
    ]
)
