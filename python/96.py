from functools import cache


class Solution:
    def numTrees(self, n: int) -> int:
        return self.dfs(1, n)

    @cache
    def dfs(self, start, end):
        if start == end:
            return 1
        if start > end:
            return 1
        result = 0
        for i in range(start, end + 1):
            left = self.dfs(start, i - 1)
            right = self.dfs(i + 1, end)
            result += left * right
        return result


Solution().numTrees(19)
