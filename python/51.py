from pyparsing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def DFS(queens, xy_diff, xy_sum):
            p = len(queens)
            if p == n:
                result.append(queens)
                return
            for q in range(n):
                if q not in queens and p - q not in xy_diff and p + q not in xy_sum:
                    xy_diff.add(p - q)
                    xy_sum.add(p + q)
                    DFS(queens + [q], xy_diff, xy_sum)
                    xy_diff.remove(p - q)
                    xy_sum.remove(p + q)

        result = []
        DFS([], set(), set())
        return [["." * i + "Q" + "." * (n - i - 1) for i in sol] for sol in result]


Solution().solveNQueens(4)
