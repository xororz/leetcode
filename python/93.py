from typing import List


class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        return self.dfs(s, 3)

    def dfs(self, s: str, dot_num: int) -> List[str]:
        if len(s) == 0:
            return []
        if dot_num == 0:
            if s[0] == "0":
                if len(s) == 1:
                    return ["0"]
                else:
                    return []
            else:
                if len(s) > 3:
                    return []
                if int(s) < 256:
                    return [s]
                return []
        else:
            ans = []
            if s[0] == "0":
                for tmp in self.dfs(s[1:], dot_num - 1):
                    ans.append("0." + tmp)
                return ans
            else:
                for i in range(1, len(s)):
                    if int(s[:i]) < 256:
                        for tmp in self.dfs(s[i:], dot_num - 1):
                            ans.append(s[:i] + "." + tmp)
                    else:
                        break
            return ans


Solution().restoreIpAddresses("172162541")
