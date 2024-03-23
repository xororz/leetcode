package java189;

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < k)
                res[i] = nums[n - k + i];
            else
                res[i] = nums[i - k];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }
}