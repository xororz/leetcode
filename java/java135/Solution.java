package java135;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int candy(int[] ratings) {
        int mark = 0;
        int n = ratings.length;
        int[] c = new int[n];
        if (n == 1)
            return 1;
        int i;
        int res = 0;
        for (i = 0; i < n - 1; i++) {
            if (ratings[i] == ratings[i + 1]) {
                res += cut(ratings, mark, i, c);
                mark = i + 1;
            }
        }
        res += cut(ratings, mark, i, c);
        return res;
    }

    public int cut(int[] ratings, int start, int end, int[] c) {
        if (start == end) {
            return 1;
        }
        if (start + 1 == end) {
            if (ratings[start] == ratings[end])
                return 2;
            return 3;
        }
        List<Integer> l = new ArrayList<>();
        if (ratings[start] < ratings[start + 1])
            l.add(start);
        int i;
        for (i = start + 1; i < end; i++) {
            if (ratings[i] < Math.min(ratings[i - 1], ratings[i + 1])) {
                l.add(i);
            }
        }
        if (ratings[end] < ratings[end - 1]) {
            l.add(end);
        }
        for (int low : l) {
            if (low == start) {
                c[low] = 1;
                for (i = start; i < end; i++) {
                    if (ratings[i] < ratings[i + 1]) {
                        c[i + 1] = c[i] + 1;
                    }
                    if (ratings[i] > ratings[i + 1]) {
                        break;
                    }
                }
            } else if (low == end) {
                c[low] = 1;
                for (i = end; i > start; i--) {
                    if (ratings[i] < ratings[i - 1] && c[i] >= c[i - 1]) {
                        c[i - 1] = c[i] + 1;
                    }
                    if (ratings[i] > ratings[i - 1]) {
                        break;
                    }
                }
            } else {
                c[low] = 1;
                for (i = low; i > start; i--) {
                    if (ratings[i] < ratings[i - 1] && c[i] >= c[i - 1]) {
                        c[i - 1] = c[i] + 1;
                    }
                    if (ratings[i] > ratings[i - 1]) {
                        break;
                    }
                }
                for (i = low; i < end; i++) {
                    if (ratings[i] < ratings[i + 1]) {
                        c[i + 1] = c[i] + 1;
                    }
                    if (ratings[i] > ratings[i + 1]) {
                        break;
                    }
                }
            }
        }
        int res = 0;
        for (i = start; i <= end; i++) {
            res += c[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ratings = { 1, 2, 2 };
        System.out.println(new Solution().candy(ratings));
    }
}