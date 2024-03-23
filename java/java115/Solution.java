package java115;

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int res[][] = new int[n][m];
        int base = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = 0;
            }
        }
        if (s.charAt(0) == t.charAt(0)) {
            res[0][0] = 1;
        }
        for (int i = 1; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (t.charAt(j) == s.charAt(i)) {
                    if (j == 0) {
                        res[i][j] = res[i - 1][j] + 1;
                        res[i][j] %= base;
                    } else {
                        res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
                        res[i][j] %= base;
                    }
                } else {
                    res[i][j] = res[i - 1][j];
                }
            }
        return res[n - 1][m - 1];
    }
}