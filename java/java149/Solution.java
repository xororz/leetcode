package java149;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1)
            return 1;
        int i, j;
        Map<Pair, Integer> m = new HashMap<>();
        int x1, y1, x2;
        double y2;
        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                x1 = points[i][0];
                x2 = points[j][0];
                y1 = points[i][1];
                y2 = (double) points[j][1];
                if (x1 != x2) {
                    Pair p = new Pair((y2 - y1) * (x2 - x1), (x2 * y1 - x1 * y2) * (x2 - x1));
                    m.put(p, m.getOrDefault(p, 0) + 1);
                } else {
                    Pair p = new Pair(Double.MAX_VALUE, x1);
                    m.put(p, m.getOrDefault(p, 0) + 1);
                }
            }
        }
        int res = 0;
        for (int v : m.values()) {
            res = Math.max(v, res);
        }
        if (res == 1)
            return 2;
        return (int) (Math.sqrt(res) + 2);
    }

    public static void main(String[] args) {
        int[][] points = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
        Solution s = new Solution();
        int res = s.maxPoints(points);
        System.out.println(res);
    }
}