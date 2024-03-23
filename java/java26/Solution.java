package java26;

class Solution {
    public int removeDuplicates(int[] nums) {
        int i;
        int start = 0;
        int s = 1;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                s++;
                start++;
                nums[start] = nums[i + 1];
            }
        }
        return s;
    }
}