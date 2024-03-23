from typing import List


class Solution:
    def maxPalindromesAfterOperations(self, words: List[str]) -> int:
        d = {}
        for word in words:
            for c in word:
                d[c] = d.get(c, 0) + 1
        c_num = 0
        for c in d:
            c_num += d[c] // 2
        res = 0
        lens = [len(word) for word in words]
        lens.sort()
        for i in range(len(words)):
            if c_num >= lens[i] // 2:
                res += 1
                c_num -= lens[i] // 2
            else:
                break
        return res
