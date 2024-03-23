package java34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        int n = nums.length;
        if (n == 0)
            return ans;
        if (n == 1) {
            if (nums[0] == target) {
                ans[0] = 0;
                ans[1] = 0;
            } else
                return ans;
        }
        int left = 1, right = n - 1;
        int mid = -1;
        if (nums[0] != target) {
            while (left <= right) {
                mid = (left + right) / 2;
                if (nums[mid - 1] < target && nums[mid] == target)
                    break;
                if (nums[mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            if (nums[mid] != target) {
                return ans;
            }
        } else
            mid = 0;
        ans[0] = mid;
        left = mid;
        right = n - 2;
        if (nums[n - 1] == target) {
            ans[1] = n - 1;
            return ans;
        }
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target && nums[mid + 1] > target)
                break;
            if (nums[mid] == target)
                left = mid + 1;
            else
                right = mid - 1;

        }
        ans[1] = mid;
        return ans;

    }
}