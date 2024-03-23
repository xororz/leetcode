package java43;

class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        String ans = "";
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int sum = pos[i + j + 1] + x * y;
                pos[i + j + 1] = sum % 10;
                pos[i + j] += sum / 10;
            }
        }
        for (int p : pos) {
            if (!(ans.length() == 0 && p == 0)) {
                ans += p;
            }
        }
        return ans.length() == 0 ? "0" : ans;

    }
}