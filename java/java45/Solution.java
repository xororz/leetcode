package java45;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        int ans[] = new int[n];
        int i, j;
        for (i = n - 1; i >= 0; i--) {
            ans[i] = n;
            if (i + nums[i] >= n - 1)
                ans[i] = 1;
            else {
                for (j = i + 1; j < n - 1 && j <= i + nums[i]; j++) {
                    if (ans[i] > ans[j] + 1) {
                        ans[i] = ans[j] + 1;
                    }
                }
            }
        }
        return ans[0];
    }
}