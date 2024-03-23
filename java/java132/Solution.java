package java132;

class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isHuiwen = new boolean[n][n];
        int i, j;
        for (i = n - 1; i >= 0; i--) {
            for (j = 0; j < n; j++) {
                if (i >= j)
                    isHuiwen[i][j] = true;
                else {
                    isHuiwen[i][j] = isHuiwen[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }
            }
        }
        int[] m = new int[n];
        m[n - 1] = 0;
        for (i = n - 2; i >= 0; i--) {
            m[i] = Integer.MAX_VALUE;
            for (j = i; j < n; j++) {
                if (isHuiwen[i][j]) {
                    if (j == n - 1)
                        m[i] = 0;
                    else {
                        m[i] = Math.min(m[i], m[j + 1] + 1);
                    }
                }
            }
        }
        return m[0];
    }

}