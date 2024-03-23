from typing import List


class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry = 1
        for i in range(len(digits) - 1, -1, -1):
            if carry == 0:
                break
            digits[i] += carry
            carry = digits[i] // 10
            digits[i] %= 10
        if carry:
            digits.insert(0, carry)
        return digits
