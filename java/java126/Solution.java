package java126;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, Boolean> map;

    public boolean sb(String a, String b) {
        if (map.containsKey(a + " " + b))
            return map.get(a + " " + b);
        int n = a.length();
        int diff = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i))
                diff++;
        }
        map.put(a + " " + b, diff == 1);
        return diff == 1;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        map = new HashMap<>();
        List<LinkedList<String>> res = new ArrayList<>();
        List<List<String>> res2 = new ArrayList<>();
        int n = wordList.size();
        boolean[] v = new boolean[n];
        List<Integer> now = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (sb(wordList.get(i), beginWord)) {
                now.add(i);
            }
        }
        bfs(wordList, v, now, res, endWord);
        for (int i = 0; i < res.size(); i++) {
            LinkedList<String> l = res.get(i);
            l.addFirst(beginWord);
            res2.add(l);
        }
        return res2;
    }

    public List<Integer> bfs(List<String> wordList, boolean[] v, List<Integer> now,
            List<LinkedList<String>> res,
            String endWord) {
        int n = wordList.size();
        if (now.size() == 0) {
            return new ArrayList<>();
        }
        boolean flag = false;
        List<Integer> pre = new ArrayList<>();
        List<Integer> pree = new ArrayList<>();
        List<Integer> next = new ArrayList<>();
        List<Integer> tmpv = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        for (int p = 0; p < now.size(); p++) {
            int i = now.get(p);
            String word = wordList.get(i);
            if (word.equals(endWord)) {
                flag = true;
                path.add(p);
            }
            if (flag)
                continue;
            for (int j = 0; j < n; j++) {
                if (v[j])
                    continue;
                if (sb(word, wordList.get(j))) {
                    next.add(j);
                    tmpv.add(j);
                    pre.add(i);
                    pree.add(p);
                }
            }
        }
        for (int i : tmpv) {
            v[i] = true;
        }
        if (flag) {
            for (int i : path) {
                LinkedList<String> l = new LinkedList<>();
                l.add(wordList.get(now.get(i)));
                res.add(l);
            }
            return path;
        }
        List<Integer> last = bfs(wordList, v, next, res, endWord);
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < last.size(); i++) {
            LinkedList<String> l = res.get(i);
            l.addFirst(wordList.get(pre.get(last.get(i))));
            r.add(pree.get(last.get(i)));
        }
        return r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // String beginWord = "red";
        // String endWord = "tax";
        // List<String> wordList = new ArrayList<>(Arrays.asList("ted", "tex", "red",
        // "tax", "tad", "den", "rex", "pee"));
        // System.out.println(s.findLadders(beginWord, endWord, wordList));
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog",
                "lot", "log", "cog"));
        System.out.println(s.findLadders(beginWord, endWord, wordList));
    }
}