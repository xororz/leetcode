package java118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < i + 2; j++) {
                if (j == 0 || j == i + 1) {
                    tmp.add(1);
                } else {
                    tmp.add(res.get(i).get(j - 1) + res.get(i).get(j));
                }
            }
            res.add(tmp);
        }
        return res;
    }
}