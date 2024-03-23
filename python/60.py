from typing import List


class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        k = k - 1
        l = [i + 1 for i in range(n)]
        ans = ""
        base = 1
        for i in range(1, n + 1):
            base *= i
        for i in range(n, 0, -1):
            base /= i
            idx = int(k // base)
            ans += str(l.pop(idx))
            k %= base
        return ans


s = Solution()
s.getPermutation(4, 4)
