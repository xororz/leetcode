package java30;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class s30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int slen = s.length();
        int wnum = words.length;
        int wlen = words[0].length();
        int i, j, left, right;
        String tmp;
        Map<String, Integer> standard = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        int diff;
        for (i = 0; i < wnum; i++) {
            tmp = words[i];
            standard.put(tmp, standard.getOrDefault(tmp, 0) + 1);
        }
        for (i = 0; i < wlen; i++) {
            left = i;
            right = i + wnum * wlen;
            if (right > slen)
                continue;
            diff = standard.size();
            for (String key : standard.keySet()) {
                map.put(key, standard.get(key));
            }
            for (j = left; j < right; j += wlen) {
                tmp = s.substring(j, j + wlen);
                if (map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp) - 1);
                    if (map.get(tmp) == 0) {
                        diff--;
                    }
                    if (map.get(tmp) == -1) {
                        diff++;
                    }
                }
            }
            if (diff == 0) {
                ans.add(left);
            }
            while (right <= slen - wlen) {
                tmp = s.substring(left, left + wlen);
                if (map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp) + 1);
                    if (map.get(tmp) == 1) {
                        diff++;
                    }
                    if (map.get(tmp) == 0) {
                        diff--;
                    }
                }
                tmp = s.substring(right, right + wlen);
                if (map.containsKey(tmp)) {
                    map.put(tmp, map.get(tmp) - 1);
                    if (map.get(tmp) == 0) {
                        diff--;
                    }
                    if (map.get(tmp) == -1) {
                        diff++;
                    }
                }
                left += wlen;
                right += wlen;
                if (diff == 0) {
                    ans.add(left);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        s30 s = new s30();
        String[] words = { "word", "good", "best", "good" };
        System.out.println(s.findSubstring("wordgoodgoodgoodbestword", words));
    }
}