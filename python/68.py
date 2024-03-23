from typing import List


class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        ans = []
        self.makeline(words, maxWidth, 0, ans)
        return ans

    def makeline(self, words, maxWidth, start, ans):
        if start >= len(words):
            return
        length = len(words[start])
        line = words[start]
        for i in range(start + 1, len(words)):
            if length + len(words[i]) + 1 > maxWidth:
                break
            length += len(words[i]) + 1
        else:
            for i in range(start + 1, len(words)):
                line += " " + words[i]
            line += " " * (maxWidth - len(line))
            ans.append(line)
            return
        space_num = maxWidth
        for j in range(start, i):
            space_num -= len(words[j])
        word_num = i - start
        space_loc = word_num - 1
        if space_loc == 0:
            line += " " * (maxWidth - len(line))
            ans.append(line)
            return self.makeline(words, maxWidth, i, ans)
        extra = space_num % space_loc
        n_space = space_num // space_loc
        for j in range(start + 1, start + 1 + extra):
            line += " " * (n_space + 1) + words[j]
        for j in range(start + 1 + extra, i):
            line += " " * n_space + words[j]
        ans.append(line)
        return self.makeline(words, maxWidth, i, ans)


s = Solution()
l = ["This", "is", "an", "example", "of", "text", "justification."]
s.fullJustify(l, 16)
