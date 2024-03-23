package java31;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i, j, tmp;
        for (i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            for (j = 0; j < n / 2; j++) {
                tmp = nums[j];
                nums[j] = nums[n - 1 - j];
                nums[n - 1 - j] = tmp;
            }
            return;
        }
        for (j = n - 1; j >= i; j--) {
            if (nums[j] > nums[i - 1]) {
                break;
            }
        }
        tmp = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = tmp;
        for (j = 0; j < (n - i) / 2; j++) {
            tmp = nums[i + j];
            nums[i + j] = nums[n - 1 - j];
            nums[n - 1 - j] = tmp;
        }
    }
}