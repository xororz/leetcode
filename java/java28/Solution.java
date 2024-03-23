package java28;

import java.util.Arrays;

class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        int next[] = new int[len];
        next[0] = 0;
        int i, j;
        i = 0;
        j = 1;
        for (j = 1; j < len; j++) {
            if (needle.charAt(i) == needle.charAt(j)) {
                i++;
                next[j] = i;
            } else {
                if (i > 0) {
                    i = next[i - 1];
                    j--;
                } else {
                    next[j] = 0;
                }
            }
        }
        // System.out.println(Arrays.toString(next));
        j = 0;
        for (i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == len) {
                    return i - j + 1;
                }
            } else {
                if (j > 0) {
                    j = next[j - 1];
                    i--;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        s28 s = new s28();
        System.out.println(s.strStr("leetcode", "leeto"));
    }
}