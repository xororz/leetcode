package java46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        p(nums, 0, ans);
        return ans;
    }

    public void p(int[] nums, int start, List<List<Integer>> ans) {
        if (start == nums.length - 1) {
            List<Integer> tmp = new ArrayList<>();
            for (int i : nums) {
                tmp.add(i);
            }
            ans.add(tmp);
        }
        for (int i = start; i < nums.length; i++) {
            int tmp = nums[start];
            nums[start] = nums[i];
            nums[i] = tmp;
            p(nums, start + 1, ans);
            nums[i] = nums[start];
            nums[start] = tmp;
        }
    }
}