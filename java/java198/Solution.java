package java198;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] p = new int[n];
        int[] q = new int[n];
        p[0] = nums[0];
        q[0] = 0;
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            p[i] = q[i - 1] + nums[i];
            q[i] = Math.max(p[i - 1], q[i - 1]);
            res = Math.max(res, p[i]);
            res = Math.max(res, q[i]);
        }
        return res;
    }
}