package java131;

import java.util.ArrayList;
// import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s, 0, res, path);
        return res;
    }

    public boolean isHuiwen(String s, int start, int end) {
        for (int i = start; i < (end + start) / 2; i++) {
            if (s.charAt(i) != s.charAt(end + start - i - 1))
                return false;
        }
        return true;
    }

    public void dfs(String s, int start, List<List<String>> res, List<String> path) {
        if (start == s.length()) {
            // LinkedList<String> l = new LinkedList<>(path);
            ArrayList<String> l = new ArrayList<>(path);
            res.add(l);
        }
        for (int i = start; i < s.length(); i++) {
            if (isHuiwen(s, start, i + 1)) {
                path.add(s.substring(start, i + 1));
                dfs(s, i + 1, res, path);
                path.remove(path.size() - 1);
            }
        }
    }
}