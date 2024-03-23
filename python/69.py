class Solution:
    def mySqrt(self, x: int) -> int:
        left, right = 0, 46340
        while left <= right:
            mid = (left + right) // 2
            if mid**2 == x:
                return mid
            if mid**2 > x:
                right = mid - 1
            if mid**2 < x:
                left = mid + 1
        return right
