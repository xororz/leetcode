package java128;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        int n = nums.length;
        List<Map<Integer, Integer>> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(new HashMap<>());
        }
        for (int num : nums) {
            int loc = num % n;
            if (num < 0) {
                loc = (num + (1 - num / n) * n) % n;
            }
            l.get(loc).put(num, 1);
        }
        int res = 1;
        Map<Integer, Integer> curMap;
        Map<Integer, Integer> nextMap;
        for (int i = 0; i < n - 1; i++) {
            curMap = l.get(i);
            nextMap = l.get(i + 1);
            for (int num : curMap.keySet()) {
                if (nextMap.containsKey(num + 1)) {
                    nextMap.put(num + 1, curMap.get(num) + 1);
                    res = Math.max(res, curMap.get(num) + 1);
                }
            }
        }
        curMap = l.get(n - 1);
        nextMap = l.get(0);
        for (int num : curMap.keySet()) {
            if (nextMap.containsKey(num + 1)) {
                nextMap.put(num + 1, curMap.get(num) + 1);
                res = Math.max(res, curMap.get(num) + 1);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            curMap = l.get(i);
            nextMap = l.get(i + 1);
            for (int num : curMap.keySet()) {
                if (nextMap.containsKey(num + 1)) {
                    nextMap.put(num + 1, curMap.get(num) + 1);
                    res = Math.max(res, curMap.get(num) + 1);
                }
            }
        }
        return res;
    }
}