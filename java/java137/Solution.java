package java137;

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int tmp = 0;
            for (int num : nums) {
                if (((num >> i) & 1) == 1) {
                    tmp += 1;
                }
            }
            res += (tmp % 3) * (1 << i);
        }
        return res;
    }
}