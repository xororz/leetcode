from pyparsing import List


class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if not matrix:
            return []
        h, w = len(matrix), len(matrix[0])
        ans = []
        for i in range((min(h, w) + 1) // 2):
            for j in range(i, w - i):
                ans.append(matrix[i][j])
            for j in range(i + 1, h - i):
                ans.append(matrix[j][w - i - 1])
            for j in range(w - i - 2, i - 1, -1):
                ans.append(matrix[h - i - 1][j])
            for j in range(h - i - 2, i, -1):
                ans.append(matrix[j][i])
        return ans[: h * w]


s = Solution()
print(s.spiralOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
