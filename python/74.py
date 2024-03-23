from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        left, right = 0, len(matrix) - 1
        while left <= right:
            mid = (left + right) // 2
            if mid == len(matrix) - 1:
                if matrix[mid][0] <= target:
                    break
            if matrix[mid][0] <= target < matrix[mid + 1][0]:
                break
            elif matrix[mid][0] > target:
                right = mid - 1
            else:
                left = mid + 1
        if left > right:
            return False
        l = matrix[mid]
        left, right = 0, len(matrix[0]) - 1
        while left <= right:
            mid = (left + right) // 2
            if l[mid] == target:
                break
            elif l[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        if left > right:
            return False
        return True
