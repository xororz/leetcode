from typing import List


class Solution:
    def countOfPairs(self, n: int, x: int, y: int) -> List[int]:
        if x > y:
            x, y = y, x
        d = y - x
        if d == 0 or d == 1:
            return [(n - 1 - i) * 2 for i in range(n)]
        c = [0 for i in range(n)]
        for i in range((d + 1) // 2):
            c[i] += (d + 1 - i) * 2
        left = x - 1
        right = n - y
        line = n - d + 1
        for i in range(line - 1):
            c[i] += (line - i - 1) * 2
        for i in range((d - 1) // 2):
            pass
