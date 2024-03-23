from collections import deque


class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = deque()
        for i in path.split("/"):
            if i == "." or i == "":
                continue
            elif i == "..":
                if len(stack) > 0:
                    stack.pop()
            else:
                stack.append(i)
        if len(stack) == 0:
            return "/"
        ans = ""
        for i in stack:
            ans += "/" + i
        return ans
