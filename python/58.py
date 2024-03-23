class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        ans = 0
        start = True
        for c in s[::-1]:
            if c == " " and start:
                continue
            else:
                start = False
                if c == " ":
                    break
                ans += 1
        return ans
