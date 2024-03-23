from collections import deque


class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        l = deque([1, 2], maxlen=2)
        for i in range(n - 2):
            l.append(l[0] + l[-1])
        return l[-1]
