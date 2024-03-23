package java122;

class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length == 1)
            return res;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}