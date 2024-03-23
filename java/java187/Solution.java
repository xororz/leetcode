package java187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        int n = s.length();
        if (n <= 10)
            return res;
        for (int i = 0; i <= n - 10; i++) {
            String tmp = s.substring(i, i + 10);
            m.put(tmp, m.getOrDefault(tmp, 0) + 1);
        }
        System.out.println(m.toString());
        for (String tmp : m.keySet()) {
            if (m.get(tmp) > 1)
                res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().findRepeatedDnaSequences("AAAAAAAAAAA");
    }
}