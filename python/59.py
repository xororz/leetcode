from typing import List


class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        matrix = [[0] * n for _ in range(n)]
        m = {
            (0, 1): (1, 0),
            (1, 0): (0, -1),
            (0, -1): (-1, 0),
            (-1, 0): (0, 1),
        }
        v = (0, 1)
        i, j = 0, 0
        now = 1
        for r in range((n + 1) // 2):
            step = n - 2 * r - 1
            if step == 0:
                matrix[i][j] = now
                break
            for _ in range(4):
                for __ in range(step):
                    matrix[i][j] = now
                    now += 1
                    i += v[0]
                    j += v[1]
                v = m[v]
            i += 1
            j += 1
        return matrix


# Time: O(n^2)
# Space: O(n^2)
s = Solution()
print(s.generateMatrix(4))
