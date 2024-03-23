package java42;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            left[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = max;
            max = Math.max(max, height[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            int water = Math.min(left[i], right[i]) - height[i];
            if (water > 0) {
                result += water;
            }
        }
        return result;
    }
}