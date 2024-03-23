package java120;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1)
            return triangle.get(0).get(0);
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            List<Integer> next = triangle.get(i + 1);
            for (int j = 0; j < i + 1; j++) {
                row.set(j, Math.min(next.get(j), next.get(j + 1)) + row.get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}