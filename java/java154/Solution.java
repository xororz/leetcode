package java154;

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int base = nums[0];
        if (n == 1)
            return base;
        int left = 1, right = n - 1;
        if (nums[right] < base && nums[right] < nums[right - 1])
            return nums[right];
        right--;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] <= nums[right])
                right -= 1;
            else
                left = mid + 1;
        }
        return base;
    }
}