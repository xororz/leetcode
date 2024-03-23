package java172;

import java.util.HashMap;
import java.util.Map;

class Solution {
    static Map<Integer, Integer> m = new HashMap<>();
    static {
        int n2 = 0, n5 = 0;
        m.put(0, 0);
        for (int j = 1; j < 10001; j++) {
            int i = j;
            while (i % 2 == 0) {
                n2++;
                i /= 2;
            }

            while (i % 5 == 0) {
                n5++;
                i /= 5;
            }
            m.put(j, Math.min(n2, n5));
        }
    }

    public int trailingZeroes(int n) {
        return m.get(n);
    }
}