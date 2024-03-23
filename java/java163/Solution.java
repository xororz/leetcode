package java163;

class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;
        int maxv = Integer.MIN_VALUE;
        int minv = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            maxv = Math.max(maxv, nums[i]);
            minv = Math.min(minv, nums[i]);
        }
        if (maxv == minv)
            return 0;
        int size = (maxv - minv) / (n - 1);
        if (size == 0)
            size = 1;
        int numBoxes = (maxv - minv) / size + 1;
        int[] boxmax = new int[numBoxes];
        int[] boxmin = new int[numBoxes];
        for (int i = 0; i < numBoxes; i++) {
            boxmax[i] = Integer.MIN_VALUE;
            boxmin[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            int idx = (nums[i] - minv) / size;
            boxmax[idx] = Math.max(boxmax[idx], nums[i]);
            boxmin[idx] = Math.min(boxmin[idx], nums[i]);
        }
        int res = 0;
        int go = boxmax[0];
        for (int i = 1; i < numBoxes; i++) {
            if (boxmin[i] != Integer.MAX_VALUE) {
                res = Math.max(res, boxmin[i] - go);
                go = boxmax[i];
            }
        }
        return res;
    }
}