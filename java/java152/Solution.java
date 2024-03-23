package java152;

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = nums[0];
        dp2[0] = nums[0];
        int res = dp1[0];
        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(nums[i] * dp1[i - 1], nums[i]);
            dp1[i] = Math.max(nums[i] * dp2[i - 1], dp1[i]);
            dp2[i] = Math.min(nums[i] * dp2[i - 1], nums[i]);
            dp2[i] = Math.min(nums[i] * dp1[i - 1], dp2[i]);
            res = Math.max(res, dp1[i]);
        }
        return res;
    }
}