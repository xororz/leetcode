package java49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int n = s.length();
            int count[] = new int[26];
            for (int i = 0; i < n; i++) {
                count[s.charAt(i) - 'a']++;
            }
            StringBuilder ss = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    ss.append((char) ('a' + i));
                    ss.append(count[i]);
                }
            }
            String sss = ss.toString();
            List<String> l = map.getOrDefault(sss, new ArrayList<String>());
            l.add(s);
            map.put(sss, l);
        }
        return new ArrayList<>(map.values());
    }
}