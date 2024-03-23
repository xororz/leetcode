class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m, n = len(word1), len(word2)
        if m == 0:
            return n
        if n == 0:
            return m
        dp = [[] for i in range(m)]
        dp[0].append(int(word1[0] != word2[0]))
        for i in range(n - 1):
            dp[0].append(i + 2 - (word1[0] in word2[: i + 2]))
        for i in range(m - 1):
            dp[i + 1].append(i + 2 - (word2[0] in word1[: i + 2]))
        for i in range(1, m):
            for j in range(1, n):
                if word1[i] == word2[j]:
                    dp[i].append(
                        min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1])
                    )
                else:
                    dp[i].append(
                        min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1)
                    )
        return dp[-1][-1]


s = Solution()
s.minDistance("horse", "ros")
