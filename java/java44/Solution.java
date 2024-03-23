package java44;

class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean match[][] = new boolean[n + 1][m + 1];
        match[0][0] = true;
        int i, j;
        for (i = 0; i < n; i++) {
            if (p.charAt(i) == '*')
                match[i + 1][0] = true;
            else
                break;
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                match[i + 1][j + 1] = false;
                if ((p.charAt(i) == '?' || p.charAt(i) == '*' || p.charAt(i) == s.charAt(j)) && match[i][j]) {
                    match[i + 1][j + 1] = true;
                }
                if (p.charAt(i) == '*' && match[i][j]) {
                    match[i][j + 1] = true;
                    match[i + 1][j] = true;
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (match[i][m] && p.charAt(i) == '*') {
                match[i + 1][m] = true;
            }
        }
        for (i = 0; i < n + 1; i++) {
            for (j = 0; j < m + 1; j++) {
                if (match[i][j])
                    System.out.print(1 + " ");
                else
                    System.out.print(0 + " ");
            }
            System.out.println();
        }
        return match[n][m];
    }
}