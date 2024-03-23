package java151;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

class Solution {
    public String reverseWords(String s) {
        String[] l = s.split(" ");
        List<String> ll = Arrays.asList(l);
        Collections.reverse(ll);
        StringJoiner sj = new StringJoiner(" ");
        for (String c : ll) {
            if (c.equals(""))
                continue;
            sj.add(c);
        }
        return sj.toString();
    }
}