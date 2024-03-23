package java40;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int candidate : candidates) {
            map.put(candidate, map.getOrDefault(candidate, 0) + 1);
        }
        int[] unique = new int[map.size()];
        int[] count = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            unique[i] = entry.getKey();
            count[i] = entry.getValue();
            i++;
        }
        backtrack(unique, count, target, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] candidates, int[] count, int target, int start, List<Integer> current,
            List<List<Integer>> result) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(current));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (count[i] > 0) {
                    current.add(candidates[i]);
                    count[i]--;
                    backtrack(candidates, count, target - candidates[i], i, current, result);
                    count[i]++;
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}