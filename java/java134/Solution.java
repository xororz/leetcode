package java134;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] l = new int[n];
        for (int i = 0; i < n; i++)
            l[i] = gas[i] - cost[i];
        int i = 0;
        while (i < n) {
            int ni = next(l, i);
            if (ni == -1)
                return i;
            i = ni;
        }
        return -1;
    }

    public int next(int[] l, int start) {
        int sum = 0;
        int steps = 0;
        int s = start;
        while (sum >= 0 && steps <= l.length) {
            sum += l[start];
            steps += 1;
            start += 1;
            start = start % l.length;
        }
        if (sum < 0) {
            if (start <= s)
                return l.length;
            else
                return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = { 2, 3, 4 };
        int[] cost = { 3, 4, 3 };
        System.out.println(new Solution().canCompleteCircuit(gas, cost));
    }
}