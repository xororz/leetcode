package java121;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;
        if (n == 2)
            return Math.max(prices[1] - prices[0], 0);
        int[] m = new int[n];
        m[0] = 0;
        m[1] = prices[1] - prices[0];
        int res = Math.max(0, m[1]);
        for (int i = 2; i < n; i++) {
            m[i] = Math.max(0, m[i - 1]) + prices[i] - prices[i - 1];
            res = Math.max(res, m[i]);
        }
        return res;
    }
}