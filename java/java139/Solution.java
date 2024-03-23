package java139;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int maxlen = 0;

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n; i >= 1; i--) {
            if (!dp[i])
                continue;
            for (String w : wordDict) {
                int wl = w.length();
                if (i - wl < 0)
                    continue;
                if (s.substring(i - wl, i).equals(w))
                    dp[i - wl] = true;
            }
        }
        return dp[0];

    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> l = new ArrayList<>();
        l.add("leet");
        l.add("code");
        System.out.println(new Solution().wordBreak(s, l));
    }
}