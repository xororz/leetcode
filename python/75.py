from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        left, right = 0, len(nums) - 1
        for left in range(len(nums)):
            if nums[left] != 0:
                break
        else:
            return
        for right in range(len(nums) - 1, -1, -1):
            if nums[right] != 2:
                break
        else:
            return
        i = left
        while i <= right:
            if nums[i] == 0:
                nums[left], nums[i] = nums[i], nums[left]
                left += 1
                if nums[i] == 2:
                    nums[right], nums[i] = nums[i], nums[right]
                    right -= 1
                    while nums[right] == 2:
                        right -= 1

            elif nums[i] == 2 and i <= right:
                nums[right], nums[i] = nums[i], nums[right]
                right -= 1
                while nums[right] == 2:
                    right -= 1
                if nums[i] == 0:
                    nums[left], nums[i] = nums[i], nums[left]
                    left += 1
            i += 1


Solution().sortColors([0, 1])
