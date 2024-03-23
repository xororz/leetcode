package java140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

class Solution {
    List<String> res;
    List<String> path;
    Set<String> m;

    public List<String> wordBreak(String s, List<String> wordDict) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        m = new HashSet<>();
        for (String w : wordDict)
            m.add(w);
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int start) {
        if (start == s.length()) {
            StringJoiner sj = new StringJoiner(" ");
            for (String w : path)
                sj.add(w);
            res.add(sj.toString());
        }
        for (int i = start + 1; i < s.length() + 1; i++) {
            if (m.contains(s.substring(start, i))) {
                path.add(s.substring(start, i));
                dfs(s, i);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        Solution sol = new Solution();
        System.out.println(sol.wordBreak(s, wordDict));
    }
}