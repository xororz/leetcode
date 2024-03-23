package java27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        int s = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                s++;
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return s;

    }
}