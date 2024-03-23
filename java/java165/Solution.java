package java165;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        List<Integer> l1 = Arrays.stream(v1).map((s) -> Integer.valueOf(s)).toList();
        String[] v2 = version2.split("\\.");
        List<Integer> l2 = Arrays.stream(v2).map((s) -> Integer.valueOf(s)).toList();
        List<Integer> ll1 = new ArrayList<>(l1);
        List<Integer> ll2 = new ArrayList<>(l2);
        int n1 = l1.size(), n2 = l2.size();
        if (n1 < n2) {
            for (int i = 0; i < n2 - n1; i++)
                ll1.add(0);
        }
        if (n1 > n2) {
            for (int i = 0; i < n1 - n2; i++) {
                ll2.add(0);
            }
        }
        int n = ll1.size();
        for (int i = 0; i < n; i++) {
            if (ll1.get(i) < ll2.get(i))
                return -1;
            if (ll1.get(i) > ll2.get(i))
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.compareVersion("0.0.1", "0.1");
        System.out.println(ans);
    }
}