from pyparsing import List


class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        ans = -9999999
        min_num = 0
        max_num = -9999999
        current_sum = 0
        for num in nums:
            current_sum += num
            if current_sum < min_num:
                if max_num - min_num > ans:
                    ans = max_num - min_num
                min_num = current_sum
                max_num = current_sum
            if current_sum > max_num:
                max_num = current_sum
        if max_num - min_num > ans:
            ans = max_num - min_num
        if ans <= 0:
            return max(nums)
        return ans
