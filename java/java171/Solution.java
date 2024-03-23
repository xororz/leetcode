package java171;

class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int n = columnTitle.length();
        for (int i = 0; i < n; i++) {
            res *= 26;
            res += columnTitle.charAt(i) - 'A' + 1;
        }
        return res;
    }
}