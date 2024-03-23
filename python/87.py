from functools import cache


class Solution:
    def isScramble(self, s1: str, s2: str) -> bool:
        ans = self.isScramble2(s1, s2)
        self.isScramble2.cache_clear()
        return ans

    @cache
    def isScramble2(self, s1: str, s2: str) -> bool:
        if len(s1) <= 1:
            return s1 == s2
        for i in range(len(s1) - 1):
            if not s1[i] == s2[i]:
                break
        if i != 0:
            return self.isScramble2(s1[i:], s2[i:])
        diff = 0
        count = {}
        for i in range(len(s1) - 1):
            c1 = s1[i]
            c2 = s2[i]
            if c1 == c2:
                if diff == 0:
                    if self.isScramble2(s1[: i + 1], s2[: i + 1]) and self.isScramble2(
                        s1[i + 1 :], s2[i + 1 :]
                    ):
                        return True
            else:
                count[c1] = count.get(c1, 0) + 1
                count[c2] = count.get(c2, 0) - 1
                if count[c1] == 0:
                    diff -= 1
                if count[c2] == 0:
                    diff -= 1
                if count[c1] == 1:
                    diff += 1
                if count[c2] == -1:
                    diff += 1
                if diff == 0:
                    if self.isScramble2(s1[: i + 1], s2[: i + 1]) and self.isScramble2(
                        s1[i + 1 :], s2[i + 1 :]
                    ):
                        return True

        diff = 0
        count = {}
        s2 = "".join(list(reversed(s2)))
        for i in range(len(s1) - 1):
            c1 = s1[i]
            c2 = s2[i]
            if c1 == c2:
                if diff == 0:
                    if self.isScramble2(s1[: i + 1], s2[: i + 1]) and self.isScramble2(
                        s1[i + 1 :], s2[i + 1 :]
                    ):
                        return True
            else:
                count[c1] = count.get(c1, 0) + 1
                count[c2] = count.get(c2, 0) - 1
                if count[c1] == 0:
                    diff -= 1
                if count[c2] == 0:
                    diff -= 1
                if count[c1] == 1:
                    diff += 1
                if count[c2] == -1:
                    diff += 1
                if diff == 0:
                    if self.isScramble2(s1[: i + 1], s2[: i + 1]) and self.isScramble2(
                        s1[i + 1 :], s2[i + 1 :]
                    ):
                        return True
        return False


Solution().isScramble2("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd")
