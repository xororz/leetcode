package java123;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        if (prices.length == 2)
            return Math.max(0, prices[1] - prices[0]);
        int[] l1 = new int[prices.length];
        int[] l2 = new int[prices.length];
        l1[0] = 0;
        l2[1] = prices[1] - prices[0];

        for (int i = 1; i < prices.length; i++) {
            l1[i] = Math.max(l1[i - 1], 0) + prices[i] - prices[i - 1];
        }
        int maxl1 = 0;
        int res = Math.max(l2[1], 0);
        for (int i = 2; i < prices.length; i++) {
            maxl1 = Math.max(maxl1, l1[i - 1]);
            l2[i] = Math.max(maxl1, l2[i - 1]) + prices[i] - prices[i - 1];
            res = Math.max(res, l2[i]);
        }
        return res;
    }

    // public static void main(String[] args) {
    // int[] test = { 1, 4, 2 };
    // System.out.println(new Solution().maxProfit(test));
    // }
}
