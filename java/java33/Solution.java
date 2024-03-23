package java33;

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        int left = 1, right = n - 1;
        int mid = 0;
        int first = nums[0];
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > first) {
                left = mid + 1;
            } else {
                if (nums[mid - 1] > nums[mid]) {
                    break;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (target >= first) {
            left = 0;
            right = mid - 1;
        } else {
            left = mid;
            right = n - 1;
        }
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        test sol = new test();
        int[] nums = { 1, 3 };
        int target = 3;
        System.out.println(sol.search(nums, target));
    }
}