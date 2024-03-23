package java188;

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[] last = new int[n];
        int[] now = new int[n];
        int res = 0;
        for (int time = 0; time < Math.min(n - 1, k); time++) {
            now[time + 1] = prices[time + 1] - prices[time] + Math.max(0, last[time]);
            res = Math.max(res, now[time + 1]);
            int tmp = Math.max(last[time], last[time + 1]);
            for (int i = time + 2; i < n; i++) {
                now[i] = Math.max(now[i - 1], tmp) + prices[i] - prices[i - 1];
                tmp = Math.max(tmp, last[i]);
                res = Math.max(res, now[i]);
            }
            int[] swap = now;
            now = last;
            last = swap;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = { 3, 2, 6, 5, 6, 0, 3 };
        System.out.println(new Solution().maxProfit(3, prices));
        // int[] prices = { 1, 4, 2, 7 };
        // System.out.println(new Solution().maxProfit(2, prices));
    }
}