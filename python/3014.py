from collections import Counter


class Solution:
    def minimumPushes(self, word: str) -> int:
        d = Counter(word)
        l = list(d.values())
        l.sort(reverse=True)
        ans = 0
        for i in range(4):
            for j in range(8):
                if 8 * i + j < len(l):
                    ans += l[8 * i + j] * (i + 1)
                else:
                    return ans
        return ans
