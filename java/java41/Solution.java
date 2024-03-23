package java41;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        nums = Arrays.stream(nums).filter(i -> i > 0).toArray();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < nums.length && nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}