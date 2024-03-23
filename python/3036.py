from typing import List
import re


class Solution:
    def countMatchingSubarrays(self, nums: List[int], pattern: List[int]) -> int:
        n = len(nums)
        m = len(pattern)
        for i in range(n - 1, 0, -1):
            if nums[i] == nums[i - 1]:
                nums[i] = 0
            elif nums[i] > nums[i - 1]:
                nums[i] = 1
            else:
                nums[i] = 2
        s = [str(i) for i in nums[1:]]
        s = "".join(s)
        p = [str(i) if i != -1 else "2" for i in pattern]
        p = "".join(p)

        def kmp_search(s, pat):
            """KMP算法搜索字符串"""
            m, n = len(s), len(pat)
            # 创建lps数组用于保存最长有效前后缀长度
            lps = [0] * n
            computeLPSArray(pat, lps)

            i = j = 0
            count = 0
            while i < m:
                if pat[j] == s[i]:
                    i += 1
                    j += 1

                if j == n:
                    # 当找到一个匹配时，计数增加
                    count += 1
                    j = lps[j - 1]

                elif i < m and pat[j] != s[i]:
                    if j != 0:
                        j = lps[j - 1]
                    else:
                        i += 1
            return count

        def computeLPSArray(pat, lps):
            """计算KMP算法中的LPS数组"""
            length = 0
            i = 1
            while i < len(pat):
                if pat[i] == pat[length]:
                    length += 1
                    lps[i] = length
                    i += 1
                else:
                    if length != 0:
                        length = lps[length - 1]
                    else:
                        lps[i] = 0
                        i += 1

        return kmp_search(s, p)


Solution().countMatchingSubarrays(
    [
        81322310,
        152123803,
        483414167,
        483414167,
        483414167,
        483414167,
        483414167,
        483414167,
        483414167,
        483414167,
    ],
    [0, 0, 0],
)  # 2
