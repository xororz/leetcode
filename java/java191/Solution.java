package java191;

class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (n >>> i) & 1;
        }
        return res;
    }
}