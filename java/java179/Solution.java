package java179;

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        Number[] ns = new Number[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ns[i] = new Number(nums[i]);
        }
        Arrays.sort(ns);
        StringBuilder sb = new StringBuilder();
        for (int i = ns.length - 1; i >= 0; i--) {
            sb.append(ns[i].num);
        }
        if (sb.charAt(0) == '0')
            return "0";
        return sb.toString();
    }
}