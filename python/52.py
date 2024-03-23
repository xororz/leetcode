from pyparsing import List


class Solution:
    def totalNQueens(self, n: int) -> int:
        ans = [0]

        def DFS(queens, xy_diff, xy_sum):
            p = len(queens)
            if p == n:
                ans[0] += 1
                return
            for q in range(n):
                if q not in queens and p - q not in xy_diff and p + q not in xy_sum:
                    xy_diff.add(p - q)
                    xy_sum.add(p + q)
                    DFS(queens + [q], xy_diff, xy_sum)
                    xy_diff.remove(p - q)
                    xy_sum.remove(p + q)

        DFS([], set(), set())
        return ans[0]


Solution().totalNQueens(4)
