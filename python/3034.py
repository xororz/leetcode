from typing import List


class Solution:
    def countMatchingSubarrays(self, nums: List[int], pattern: List[int]) -> int:
        m, n = len(nums), len(pattern)

        def check(k):
            for i in range(n):
                if not (
                    (nums[k + i + 1] > nums[k + i] and pattern[i] == 1)
                    or (nums[k + i + 1] < nums[k + i] and pattern[i] == -1)
                    or (nums[k + i + 1] == nums[k + i] and pattern[i] == 0)
                ):
                    return False
            return True

        res = 0
        for i in range(m - n):
            if check(i):
                res += 1
        return res


Solution().countMatchingSubarrays(
    [376068870, 376068870, 376068870, 412890845], [0, 1]
)  # 2
