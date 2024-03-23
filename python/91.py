class Solution:
    def numDecodings(self, s: str) -> int:
        if s.startswith("0"):
            return 0
        n = len(s)
        res = [1, 1]
        for i in range(1, n):
            tmp = 0
            if 10 <= int(s[i - 1 : i + 1]) <= 26:
                tmp += res[-2]
            if 1 <= int(s[i]) <= 9:
                tmp += res[-1]
            res.append(tmp)
        return res[-1]


Solution().numDecodings("2101")
